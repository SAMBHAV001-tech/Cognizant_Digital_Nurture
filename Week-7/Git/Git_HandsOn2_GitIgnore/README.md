# Git Hands-On 2: Ignoring Files with .gitignore

This exercise demonstrates how to use `.gitignore` to prevent unnecessary log files and directories from being tracked by Git version control.

## Key Concepts Implemented

### 1. `.gitignore` Configuration
A `.gitignore` file specifies intentionally untracked files that Git should ignore.

```gitignore
# Ignore all log files
*.log

# Ignore log directory
log/
```

### 2. Verified Behavior
- Created `app.log` and `debug.log` files in root directory.
- Created `log/` folder with `server.log` and `error.log`.
- `git status` confirmed that none of the `.log` files or the `log/` folder appear as untracked files.
- Staged and committed `.gitignore` without tracking any log artifacts.
