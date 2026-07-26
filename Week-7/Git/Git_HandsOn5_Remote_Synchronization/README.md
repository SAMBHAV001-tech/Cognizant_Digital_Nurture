# Git Hands-On 5: Remote Synchronization (Pull and Push)

This exercise demonstrates remote repository synchronization using Git CLI, ensuring local and remote repositories stay aligned through `git pull` and `git push` operations.

---

## 🛠️ Step-by-Step Commands Executed

### 1. Verify Status & Branch List
```bash
# Verify working tree is clean
git status

# List all local and tracking remote branches
git branch -a
```

---

### 2. Pull Remote Changes
Fetch and merge upstream commits from remote `master` branch:
```bash
git pull origin master
```

---

### 3. Push Local Commits
Push all pending local commits to remote GitHub repository:
```bash
git push origin master
```

---

### 4. Verify Final Synchronization
```bash
# Verify working tree status
git status

# Display recent commit log
git log -n 5 --oneline --graph --decorate
```
