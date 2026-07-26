# Git Hands-On 3: Branching and Merging

This exercise demonstrates creating lightweight Git branches, making isolated modifications, comparing branch differences, merging branches into `master`, and inspecting commit history using graph log views.

---

## 🛠️ Step-by-Step Commands Executed

### 1. Branch Creation & Navigation
```bash
# Create Feature Branch
git branch GitNewBranch

# List All Local and Remote Branches
git branch -a

# Switch to Feature Branch
git checkout GitNewBranch
```

---

### 2. Feature Development & Commit
```bash
# Create and modify files in GitNewBranch
echo "Feature branch content developed in GitNewBranch." > feature.txt

# Track and Commit Changes
git add .
git commit -m "Add feature.txt and update welcome.txt in GitNewBranch"
```

---

### 3. Switch Back, Diffing & Merging
```bash
# Switch back to main development line
git checkout master

# Compare Differences between master and GitNewBranch
git diff master..GitNewBranch

# Merge GitNewBranch into master
git merge GitNewBranch
```

*(Note: Visual diffing tools such as P4Merge can be integrated using `git config merge.tool p4merge` if P4Merge is installed locally)*

---

### 4. Graph Log & Branch Cleanup
```bash
# Display Graphical Commit History
git log --oneline --graph --decorate

# Safely Delete Merged Branch
git branch -d GitNewBranch

# Verify Working Directory Status
git status
```
