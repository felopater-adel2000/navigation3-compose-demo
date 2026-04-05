# File Locking Issue - Solution Guide

## Problem
Windows file locking issue with Gradle builds, specifically:
```
java.nio.file.FileSystemException: ...\classes.jar: The process cannot access the file because it is being used by another process
```

## Root Cause
Gradle daemon processes hold file locks on JAR files in the build directories, preventing deletion or rebuilding.

## Solutions Implemented

### 1. Gradle Configuration Optimizations (gradle.properties)
Added the following settings to reduce file locking issues:

```properties
org.gradle.parallel=true              # Enable parallel builds
org.gradle.caching=true               # Enable build caching
org.gradle.vfs.watch=true             # File system watching to reduce locks
org.gradle.configuration-cache=true   # Faster builds with configuration cache
```

### 2. Quick Fix Script (clean-build.ps1)
Created a PowerShell script to quickly resolve locking issues:

**Usage:**
```powershell
.\clean-build.ps1
```

This script:
1. Stops all Gradle daemons
2. Waits for file locks to be released
3. Removes all build directories
4. Performs a clean build

### 3. Manual Fix (When needed)
If the issue occurs during a build:

```powershell
# Step 1: Stop Gradle daemon
./gradlew --stop

# Step 2: Wait a few seconds
Start-Sleep -Seconds 3

# Step 3: Delete locked build directory
Remove-Item -Path ".\BaseModule\build" -Recurse -Force -ErrorAction SilentlyContinue

# Step 4: Clean and rebuild
./gradlew clean build
```

### 4. Alternative Build Method
Use `--no-daemon` flag to avoid daemon-related file locks:

```powershell
./gradlew clean build --no-daemon
```

Note: This is slower but avoids file locking issues entirely.

## Prevention Tips

1. **Close Android Studio before manual cleanups**: The IDE may hold file locks
2. **Use Gradle commands instead of manual deletion**: Always prefer `./gradlew clean` over manually deleting build folders
3. **Stop daemons before switching branches**: Run `./gradlew --stop` before git operations
4. **Restart IDE if persistent**: Sometimes Android Studio's indexing holds locks

## Windows-Specific Issues

Windows has stricter file locking than Linux/Mac. Common culprits:
- Gradle daemon processes
- Android Studio indexing
- Antivirus software scanning
- Windows Search indexing

**To check what's locking a file:**
```powershell
# Install if needed: Install-Module -Name SysInternals
handle.exe classes.jar
```

## Build Status
✅ Build successful after implementing fixes
✅ No more file locking errors
✅ Optimized gradle.properties for better performance

## Last Updated
April 6, 2026

