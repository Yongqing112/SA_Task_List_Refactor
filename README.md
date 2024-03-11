# Task List &nbsp; [![Build Status](https://travis-ci.org/codurance/task-list.png)](https://travis-ci.org/codurance/task-list)

2024/03/11
1.  Rearrange classes to conform to Clean Architecture
    -  Entity
        -    Task
        -    TaskList
    -  Use case
        -    Command(Interface)
        -    ShowCommand
        -    AddCommand
        -    DeleteCommand
        -    CheckCommand
        -    UnCheckCommand
        -    HelpCommand
        -    ErrorCommand
    -  Interface Adapter
        -    CommandController
    -  Framework & Driver
        -    Input
        -    Output
        -    TaskListRun

2024/03/09  
1.  Extract commands to be objects and rearrange classes to command package  
    -  Command(Interface)
    -  ShowCommand
    -  AddCommand
    -  DeleteCommand
    -  CheckCommand
    -  UnCheckCommand
    -  HelpCommand
    -  ErrorCommand
