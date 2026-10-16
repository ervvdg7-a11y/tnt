TNTDelay — source project for a Paper plugin

What it does:
- When a primed TNT entity spawns, schedules a task for the next server tick.
- Adds 10 ticks (0.5 seconds) to its current fuse.

Important:
- This is SOURCE CODE in a ZIP, not a compiled JAR.
- The Gradle file currently targets Paper API 1.21.4 and Java 21 as a conservative build example.
- It is NOT verified for Minecraft/Paper 26.3. Before building for your server, update the Paper API dependency and Java toolchain to the exact versions supported by your server.
- EntitySpawnEvent-based adjustment may not catch every TNT mechanism identically, including TNT dupers. Test on a backup/test server first.

Build:
1. Install a compatible JDK and Gradle.
2. In this folder run: gradle build
3. The JAR will be in build/libs/TNTDelay-1.0.0.jar
4. Put the JAR in the server's plugins folder and restart.

If Gradle reports an API/version issue, update the dependency in build.gradle to the Paper API matching your server.
