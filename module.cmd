@echo off
set module_name=%1
set module_id=%2

if not defined module_name goto erreof
if not defined module_id goto def_mod_id

mkdir %module_name%\src\main\java\%module_id%
mkdir %module_name%\src\main\resources

mkdir %module_name%\src\test\java\%module_id%
mkdir %module_name%\src\test\resources

type nul > %module_name%\build.gradle
goto eof

:def_mod_id
mkdir %module_name%\src\main\java\
mkdir %module_name%\src\main\resources

mkdir %module_name%\src\test\java\
mkdir %module_name%\src\test\resources

type nul > %module_name%\build.gradle
goto eof

:erreof
echo No module was created. Missing parameter 'module_name'

:eof