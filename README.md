# Bank Management System using Java RMI

This project is a simple bank management system implemented using Java's Remote Method Invocation (RMI) framework. It allows clients to perform operations such as creating an account, depositing money, withdrawing money, checking balance, and transferring funds between accounts through a graphical user interface (GUI).

## Description

The bank management system is divided into several modules:

- `Account`: A class representing a bank account with basic attributes like account ID and balance, and methods to deposit and withdraw funds.
- `BankManager`: An RMI remote interface that defines the operations that can be performed on bank accounts.
- `BankManagerImpl`: An implementation of the `BankManager` interface, providing the logic for account operations.
- `BankManagerGUI`: A `JFrame` based GUI that interacts with the `BankManager` to perform operations and display results to the user.
- `Client`: A client class that looks up the RMI registry for the `BankManager` service and initializes the GUI.
- `Server`: Sets up the RMI registry and binds the `BankManagerImpl` object to make it available to clients.

## Installation

Before running this project, ensure you have Java Development Kit (JDK) installed on your system.

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/AmmariAbdelmounaim/RMI_Java_SwingApplication.git
    cd bank-management-rmi
    ```

2. Compile the Java files:

    ```bash
    javac *.java
    ```

3. Start the RMI registry:

    ```bash
    rmiregistry &
    ```

4. Start the server:

    ```bash
    java Server
    ```

## Usage

To use the bank management system:

1. Start the server as mentioned in the installation steps.

2. Run the client to interact with the server through the GUI:

    ```bash
    java Client
    ```

3. Use the graphical user interface to perform operations like creating an account, depositing and withdrawing money, transferring funds, and checking account balances.

