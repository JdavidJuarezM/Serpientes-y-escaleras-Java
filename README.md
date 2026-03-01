<div align="center">

# 🐍🪜 Serpientes y Escaleras

**A classic board game implementation utilizing custom Data Structures in Java**

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](#)
[![Apache Ant](https://img.shields.io/badge/Apache_Ant-E25A1C?style=for-the-badge&logo=apache&logoColor=white)](#)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](#)
[![NetBeans](https://img.shields.io/badge/NetBeans_IDE-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)](#)

*Developed as the Unit 6 Integrative Project (Proyecto Integrador Unidad 6), demonstrating the practical application of custom algorithms, Trees, and Linked Lists to manage game states and board navigation.*

</div>

<br />

## 📑 Table of Contents
- [✨ Key Features](#-key-features)
- [🏗️ Architecture & Structure](#️-architecture--structure)
- [🚀 Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation & Execution](#installation--execution)
- [🤝 Contributing](#-contributing)

---

## ✨ Key Features

* **✔️ Classic Gameplay:** Fully functional "Snakes and Ladders" game logic and rules.
* **✔️ Advanced Data Structures:** Implements complex data structures from scratch, including Tree Nodes (`NodoArbol`) and Linked List Nodes (`NodoLista`), to handle the game's internal mechanics and grid.
* **✔️ Modular Game Management:** Clean separation of concerns between the game menu UI (`MenuDelJuego`) and the core administrative logic (`AdmonJuego`).
* **✔️ Multi-IDE Support:** Configured to be easily opened and compiled in both NetBeans (via `nbproject`) and IntelliJ IDEA (via `.idea` / `.iml`).

---

## 🏗️ Architecture & Structure

The repository is structured to separate the core data structures from the game's execution flow:

```text
Serpientes-y-escaleras-Java/
├── src/
│   └── src/
│       ├── MenuDelJuego.java      # Main entry point and game interface
│       ├── AdmonJuego.java        # Core game administration and logic
│       ├── NodoArbol.java         # Custom Tree Node implementation
│       └── NodoLista.java         # Custom Linked List Node implementation
├── nbproject/                     # NetBeans IDE project configurations
├── .idea/                         # IntelliJ IDEA configurations
├── DavidJuarez_...Unidad6.iml     # IntelliJ Module file
└── build.xml                      # Apache Ant build script
```

---

## 🚀 Getting Started

### Prerequisites

To compile and run this project, ensure you have:

* **Java Development Kit (JDK):** Compatible with your system.
* **Apache Ant:** (Optional) For command-line builds.
* **IDE:** NetBeans, IntelliJ IDEA, or Eclipse.

### Installation & Execution

#### Option 1: Using an IDE (IntelliJ IDEA / NetBeans)
1. Clone this repository:
   ```bash
   git clone <your-repository-url>
   ```
2. Open your preferred IDE.
3. Select **Open Project** and navigate to the cloned folder. The IDE will automatically recognize the configurations.
4. Run the `MenuDelJuego.java` file to start the game.

#### Option 2: Command Line via Apache Ant
Navigate to the project root directory and compile using Ant:
```bash
cd Serpientes-y-escaleras-Java
ant compile
ant run
```

#### Option 3: Manual Compilation (Javac)
If you prefer to compile manually from the terminal:
```bash
# Create the build directory and compile
javac -d build src/src/*.java

# Execute the compiled Main class
java -cp build src.MenuDelJuego
```

---

## 🤝 Contributing

Contributions are always welcome! If you'd like to add new features like multiplayer support or a graphical UI:

1. **Fork** the repository.
2. **Create** a new branch:
   ```bash
   git checkout -b feature/GraphicalUI
   ```
3. **Commit** your changes:
   ```bash
   git commit -m 'Add Swing components for the game board'
   ```
4. **Push** to the branch:
   ```bash
   git push origin feature/GraphicalUI
   ```
5. Open a **Pull Request**.

<br />

<div align="center">
  <i>Developed with ☕ to explore Data Structures and Algorithms in Java.</i>
</div>
