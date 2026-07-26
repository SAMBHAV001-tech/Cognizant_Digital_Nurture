# Git Hands-On 1: Git CLI Operations & Version Control

This repository documents the step-by-step execution of **Git Hands-On 1**, covering basic configuration, repository initialization, file tracking, staging, committing, and remote push/pull workflows.

---

## 🛠️ Step-by-Step Commands Executed

### 1. Environment & Configuration Setup
```bash
# Verify Git Installation
git --version

# Configure Username & Email
git config --global user.name "SAMBHAV001-tech"
git config --global user.email "sambhav@student.com"

# Configure Default Editor
git config --global core.editor "notepad"

# Verify Configuration
git config core.editor
git config --list
```

---

### 2. Repository Initialization & File Management
```bash
# Initialize Local Repository
cd GitDemo
git init

# Create Welcome File
echo "Welcome to Git Version Control System - Cognizant Digital Nurture Program." > welcome.txt

# Check Unstaged Status
git status
```

---

### 3. Staging & Committing Changes
```bash
# Stage File for Tracking
git add welcome.txt

# Commit Changes with Descriptive Message
git commit -m "Initial commit: Add welcome.txt"

# Verify Clean Working Tree
git status
```

---

### 4. Remote Repository Integration
```bash
# Configure Remote Repository URL
git remote add origin https://github.com/SAMBHAV001-tech/Cognizant_Digital_Nurture.git

# Synchronize & Pull Remote Changes
git pull origin main

# Push Local Repository to Remote Branch
git push -u origin main
```
