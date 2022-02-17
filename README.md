How to use

   • Add the repository and dependency to your plugin:

    For adding Local ".jar" 

   	1. Stop your server.
   	2. Download and drag the plugin .jar file into your plugins folder.
   	3. Start your server, and all.

  • Maven:

    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>

   	<dependency>
       	<groupId>com.github.RDProjectOfficial</groupId>
       	<artifactId>Repo name</artifactId>
       	<version>Release tag</version>
   	</dependency>

  • Add Dependency into plugin.yml (For Local .jar)
   	
	• name: ExamplePlugin
	• version: 1.0
	• api-version: "1.13"
	• main: com.rdproject.example.ExamplePlugin
	• depend: [WaterCore]

Commands:

    • /watercore - MainCommand (Shows Authors;NoPermission)
						
Features:

	• API Plugin
	• Support All Versions
	• All Customizable.
	• Lightweight and minimal performance impact.

Thanks for API's

  • ScoreBoard: https://github.com/MrMicky-FR/FastBoard
  • InventoryManager: https://github.com/MrMicky-FR/FastInv
  • SQL Database: https://github.com/forumat-plugins/ForumatCore
