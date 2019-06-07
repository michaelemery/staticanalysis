# Static Analysis Docker Information

This docker component of this project is part of M.Sc(Computer Science) thesis for Michael Emery, Massey University (2018).

### instructions

1. Ensure the docker environment is [installed and running](https://www.docker.com/products/docker-desktop). 
2. Use the console command `docker pull michaelemery/staticanalysis` to download the project Docker image. Your current or working directory is *irrelevant* as storage is managed by Docker.
3. Open an interactive project terminal with the `docker run -it --rm michaelemery/staticanalysis` command. Once downloaded, the terminal may be run as many times as needed.

    * i = *interactive*
    * t = *terminal*
    * rm = *remove container on exit*

### usage

Your terminal will open in the /src folder. Scripts to run tests are provided alongside individual test results within this GitHub repository. Copy the docker commands from the repository, and paste them directly into the Docker terminal to see the commands execute.

File edits only persist for the life of your terminal instance, so you are **encouraged to experiment** as much as you like. The next run you run the terminal, it will revert to its original state.


### resources

Your interactive terminal includes [*Vim*](https://www.vim.org/docs.php) and [*Nano*](https://wiki.gentoo.org/wiki/Nano/Basics_Guide) text editors for inspecting and modifying code. 

`vim [path]/[filename]` or `nano [path]/[filename]`
