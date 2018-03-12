# Static Analysis Docker Information

## michaelemery/staticanalysis

This project is part of M.Sc(Computer Science) thesis for Michael Emery, Massey University (2018).

## usage

Docker will open in the /checker folder. Scripts to run tests are provided in the github repository, and can also be found in the .md files located in each checker type folder (e.g alias, init, nullness, signed, taint etc.). It is recommended that you use the GitHub web interface to access these files.

### git repository
https://github.com/michaelemery/staticanalysis

### download latest container build

`docker pull michaelemery/staticanalysis`

### run container

`docker run -it --rm michaelemery/staticanalysis`

* i = interactive
* t = terminal
* rm = remove container on exit

### editing source files
To edit files, run `apt-get update`, then install vim `apt-get install vim` or nano `apt-get install nano`.
