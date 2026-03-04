@echo off
cls

set name_and_version=EZgit V.1.0

echo +------------------------+
echo ^|     %name_and_version%        ^|
echo +------------------------+

@rem Modes of the program.
set mode_init=--init
set mode_dwn=--dwn
set mode_dwn_ovrw=--dwn-ovrw
set mode_up=--up
set mode_fup=--fup
set mode_help=--help
set mode_help2=?

@rem Mode defined by the user
set mode=%1

if not defined mode goto mode_not_defined
if %mode%==%mode_init% goto init_mode
if %mode%==%mode_dwn% goto dwn_mode
if %mode%==%mode_dwn_ovrw% goto dwn_mode_ovrw
if %mode%==%mode_up% goto up_mode
if %mode%==%mode_fup% goto fup_mode
if %mode%==%mode_help% goto help_mode
if %mode%==%mode_help2% goto help_mode

:init_mode
set url=%2

if not defined url goto init_mode_missing_url
echo [Initializing]
git init .\
git remote add origin %url%
type nul > .gitignore
goto exit

:dwn_mode
set branch=%2

if not defined branch goto dwn_mode_missing_branch
echo [Pulling:%branch%]
git pull origin %branch%
goto exit

:dwn_mode_ovrw
set branch=%2

if not defined branch goto dwn_mode_missing_branch
echo [Fetching/Reseting:%branch%]
git fetch --all
git reset --hard origin/%branch%
goto exit

:up_mode
set msg=%2
set branch=%3

if not defined msg goto up_mode_missing_msg
if not defined branch goto up_mode_missing_branch
echo %msg%
echo %branch%
set /p confirm=Perform upload with specified values? (y/n) 

if %confirm%==n goto up_mode_change_values
if %confirm%==y goto up_mode_perform_upload

:up_mode_change_values
set /p confirm_mod=Modify values? (y/n) 

if %confirm_mod%==n goto exit
if %confirm_mod%==y goto up_mode_perfrom_changes

:up_mode_perfrom_changes
set /p new_msg=Commit message:  
set /p new_branch=New branch: 

echo [Pushing:%branch%]
git add .
git commit -m %msg%
git push origin %branch%
goto exit

:up_mode_perform_upload
echo [Pushing:%branch%]
git add .
git commit -m %msg%
git push origin %branch%
goto exit

:fup_mode
set msg=%2
set branch=%3

if not defined msg goto up_mode_missing_msg
if not defined branch goto up_mode_missing_branch

echo [Pushing:%branch%]
git add .
git commit -m %msg%
git push origin %branch%
goto exit

:help_mode
echo +------+
echo ^| Help ^|
echo +------+
echo Modes:
echo ------
echo %mode_init%: Initialize the current directory as git repository.
echo Flags: "url": The url of the git repository.
echo e.g.: ezgit --init https://github.com/johndoe/randomrepo
echo(
echo %mode_dwn%: Download from the git repository into the current directory.
echo Flags: "branch": The branch from which the download should be performed.
echo e.g.: ezgit --dwn master
echo(
echo %mode_dwn_ovrw%: Download from the git repository, override the contents of the current directory.
echo Flags: "branch": The branch from which the download should be performed.
echo e.g.: ezgit --dwn-ovrw master
echo(
echo %mode_up%: Upload the contents of the current directory into the git repository.
echo Flags: "branch": The branch to which the upload should be performed.
echo e.g.: ezgit --up master
echo(
echo %mode_fup%: Upload the contents of the current directory into the git repository, without the confirmation prompt.
echo Flags: "branch": The branch to which the upload should be performed.
echo e.g.: ezgit --up master
echo(
echo %mode_help%/%mode_help2%: Displays the help menu.

goto exit

@rem Error handling
:init_mode_missing_url
echo [Init-Error]: Missing repository url.
goto exit_with_err

:dwn_mode_missing_branch
echo [Dwn-Error]: Missing branch.
goto exit_with_err

:up_mode_missing_msg
echo [Up-Error]: Missing commit message.
goto exit_with_err

:up_mode_missing_branch
echo [Up-Error]: Missing branch.
goto exit_with_err

:mode_not_defined
echo [EZgit-Error]: Mode not defined. Use %mode_init%, %mode_dwn%, %mode_up% etc. Type "ezgit --help" or "ezgit ?" for help.
goto exit_with_err

:exit_with_err
set /p exit_code=Press any key to exit...
goto exit

:exit
echo(
echo %name_and_version% process finished.