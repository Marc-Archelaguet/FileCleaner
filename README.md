# FileCleaner CLI

A lightweight, modular command-line utility built in Java to organize directories, inspect files, and safely manage outdated files.

---

## Overview

Managing cluttered folders (such as `Downloads` or `Documents`) often leads to disorganized directories full of temporary files, old installers, and loose media. 

**FileCleaner CLI** simplifies this by scanning a target directory, filtering and categorizing files by their file extensions into dedicated subdirectories, and detecting files that have not been modified for an extended period so you can selectively delete them.

---

## Features

- **Directory Inspection:** Fast file listing with validation to ensure target paths exist and are valid directories.
- **Categorization & Sorting:** Automatically classifies files by extension and moves them into dedicated subfolders:
  - `Text Files`: `.txt`, `.pdf`, `.docx`, etc.
  - `Images`: `.png`, `.jpg`, `.jpeg`, etc.
  - `Others`: Fallback directory for unclassified formats.
- **Old Files Detector:** Identifies files exceeding a specific last-modified threshold (default: 30 days) and prompts for interactive deletion.
- **Console-Driven UI:** Clean, loop-based menu navigation with input sanitation and graceful error handling.

---

## Architecture & Design Principles

The application is structured around **Separation of Concerns (SoC)** to keep business logic decoupled from console input/output:

- `FileCleanerApp`: Entry point (`main`), handles user interaction, the CLI menu loop, and console feedback.
- `FileSorter`: Responsible for parsing extensions, determining destination directories, and moving files on the filesystem.
- `OldFilesChecker`: Pure logic service that computes elapsed time via `System.currentTimeMillis()` and `file.lastModified()` to filter files past the threshold.

---

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **Git** (optional, to clone the repository).

### Installation & Run

1. Clone the repository:
   ```bash
   git clone [https://github.com/Marc-Archelaguet/FileCleaner.git](https://github.com/Marc-Archelaguet/FileCleaner.git)
   cd FileCleaner
