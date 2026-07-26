# Git Hands-On 4: Merge Conflict Resolution

This exercise demonstrates creating an intentional merge conflict by making concurrent edits to the same file (`hello.xml`) across two separate branches (`master` and `GitWork`), inspecting conflict markers, manually resolving the conflict, updating `.gitignore` to ignore merge backup files (`*.orig`, `*.bak`), and finalizing the merge commit.

---

## 🛠️ Step-by-Step Commands Executed

### 1. Create Conflicting Edits across Branches
```bash
# Verify master is clean
git status

# Create and checkout GitWork branch
git checkout -b GitWork
echo "<greeting>Hello from GitWork branch</greeting>" > hello.xml
git add hello.xml
git commit -m "Add hello.xml in GitWork branch"

# Switch back to master & make conflicting edit
git checkout master
echo "<greeting>Hello from master branch</greeting>" > hello.xml
git add hello.xml
git commit -m "Add hello.xml in master branch"
```

---

### 2. Compare Branches & Trigger Intentional Conflict
```bash
# View pre-merge log tree
git log --oneline --graph --decorate --all

# Compare diff between master and GitWork
git diff master..GitWork

# Trigger merge conflict
git merge GitWork
# Output: CONFLICT (add/add): Merge conflict in hello.xml
```

---

### 3. Conflict Resolution & Merge Commit
Inspect conflict markers (`<<<<<<< HEAD`, `=======`, `>>>>>>> GitWork`) in `hello.xml` and resolve:
```xml
<greeting>Hello from master branch and GitWork branch</greeting>
```

```bash
# Stage and commit resolved file
git add hello.xml
git commit -m "Merge branch 'GitWork' and resolve conflict in hello.xml"
```

---

### 4. Update `.gitignore` for Backup Files
Add merge backup patterns (`*.orig`, `*.bak`) to `.gitignore`:
```gitignore
*.log
log/
*.orig
*.bak
```

```bash
git add .gitignore
git commit -m "Update .gitignore to ignore merge backup files"
```

---

### 5. Finalize Graph Log & Branch Cleanup
```bash
# List all branches
git branch -a

# Delete merged branch
git branch -d GitWork

# View final graph log
git log --oneline --graph --decorate

# Verify clean working tree
git status
```
