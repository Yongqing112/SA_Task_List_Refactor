# Task List &nbsp;

2024/04/24
1.  Move AddProjectUseCase to usecase.port.in.project.add and AddProjectUseCase change to Innterface

2.  Add AddProjectService to usecase.service and AddProjectService implement AddProjectUseCase

3.  Move AddTaskInput and AddTaskUseCase to usecase.ouputPort

4.  Implement Repository: ProjectListRepository(Interface) and ProjectListInMemoryRepository

    -  **entity**
        -    ProjectListId
        -    ProjectName
        -    ProjectList
        -    Project
        -    ReadOnlyProject
        -    ReadOnlyTask
        -    TaskId
        -    Task
    -  **usecase**
        -    **Service**
             -    `AddProjectService`
        -    **port/project/in/add**
             -    `AddProjectInput`
             -    `AddProjectUseCase`
        -    **outputPort**
             -    OutputBoundary(interface)
             -    OutputData
    -  **interfaceAdapter**
        -    **controller**
             -    CommandController
        -    **presenter**
             -    CommandPresenter
    -  **Persistence(Framework & Driver)**
        -    **io**
             -    Input
             -    Output
        -    TaskListRunner

2024/04/06
1.  (1) Apply DDD tactical designs to the entities layer. (2) Enforce aggregate invariants by implementing ReadOnly subtypes for Project and Task.
    -  **entity**
        -    ProjectName
        -    ProjectList
        -    Project
        -    ReadOnlyProject
        -    ReadOnlyTask
        -    TaskId
        -    Task
        -    TaskListId
        -    TaskList
    -  **usecase**
        -    **command**
             -    Command(Interface)
        -    **inputPort**
             -    InputBoundary(interface)
             -    inputData
        -    **outputPort**
             -    OutputBoundary(interface)
             -    OutputData
    -  **interfaceAdapter**
        -    **controller**
             -    CommandController
        -    **presenter**
             -    CommandPresenter
    -  **Persistence(Framework & Driver)**
        -    **io**
             -    Input
             -    Output
        -    TaskListRunner
