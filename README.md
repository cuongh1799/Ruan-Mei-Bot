# Ruan Mei Bot by Cuong

## APIs
Ruan Mei utilize the JDA API for interacting with discord, as well as using LavaPlayer to play music
For GUI, Ruan Mei use JavaFx and SceneBuilder

## How APIS are used
When push the ```run``` button, Ruan Mei will activate the main function of  ```RuanMeiDiscord.java```
### JDA
Basically a ```jda``` object will be create, this will be your discord bot object.
Using ```Commands.slash().queue()``` to add/update the commands
Example:
```
jda.updateCommands().addCommands(
            Commands.slash("roll", "Roll a number from 1 - 100"),
            Commands.slash("long", "godzilla stuff"),
            Commands.slash("path", "Let Ruan Mei choose a path for you"),
            Commands.slash("ruanmei", "schizo about ruanmei"),
            Commands.slash("hesitatetopull", "Let Silver Wolf enlighten you"),
            Commands.slash("pullruanmei", "All roads lead to Ruan Mei")
        ).queue();
```
Of course, you'll need to self implement all of your slash commmands
Example:
```
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        long time = System.currentTimeMillis();

        String[] path = {"Preservation", "Remembrance", "Nihility", "Abundance", "The Hunt", "Destruction", "Elation", "Pro gamer"};
        String godzilla = "What the fuck is actually fucking wrong with you? If Kong wins I will actually go in to a fit of rage im not sure if I could even recover from how mad it would make me. TL,DR Kong cucks can actually eat shit and I hope they all learn to not be retarded and believe in Godzilla like the god he is.";
        String ruanmeiBeautiful = "OMG shes beautiful\n";
        File silverwolfpull = new File("src/main/resources/silverwolfpull.mov");
        File allroadleadstoruanmei = new File("src/main/resources/allroadleadstoruanmei.png");

        switch (event.getName()) {
            case "long":
                event.reply("").setEphemeral(false) // reply or acknowledge
                        .flatMap(v ->
                                event.getHook().editOriginalFormat(godzilla, System.currentTimeMillis() - time) // then edit original
                        ).queue();
                break;

            case "roll":
                Random rand = new Random();
                int upperbound = 100;
                int int_random = rand.nextInt(upperbound);
                event.reply("").setEphemeral(false) // reply or acknowledge
                        .flatMap(v ->
                                event.getHook().editOriginalFormat("Rolled: " + int_random, System.currentTimeMillis() - time) // then edit original
                        ).queue();
                break;

            case "path":
                Random rand2 = new Random();
                int upperbound2 = 7;
                int int_random2 = rand2.nextInt(upperbound2);
                event.reply("").setEphemeral(false) // reply or acknowledge
                        .flatMap(v ->
                                event.getHook().editOriginalFormat("Ruan Mei chose " + path[int_random2] + " !", System.currentTimeMillis() - time) // then edit original
                        ).queue();
                break;

            case "ruanmei":
                event.reply("").setEphemeral(false) // reply or acknowledge
                        .flatMap(v ->
                                event.getHook().editOriginalFormat(ruanmeiBeautiful, System.currentTimeMillis() - time) // then edit original
                        ).queue();
                break;

            case "hesitatetopull":
                FileUpload  silverhesitate = FileUpload.fromData(silverwolfpull);
                event.replyFiles(silverhesitate).queue();
                break;

            case "pullruanmei":
                FileUpload  allroadstoruanmei = FileUpload.fromData(allroadleadstoruanmei);
                event.replyFiles(allroadstoruanmei).queue();
                break;

        }
    }
```
