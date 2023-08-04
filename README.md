# CustomCreatureDeityPassiveAggro
A Wurm Unlimited mod that will allow an administrator to override the deity no-aggro passive for Tyoda's custom creatures on a per creature basis.

Use Case: You've spent all weekend creating the perfect dungeon, complete with custom creatures tailored with just the right level of challenge for your adventurers. One week later your dungeon is filled with creatures and you find out that because of deity passives that remove aggro for certain mob types, the adventurers walk right past the mobs and go straight for the loot (while triggering more spawns along the way.)

Solution: Install this tiny mod. No configuration is needed in this mod. However, in your custom creatures config (CustomCreatures.config) each creature have a 'types' property that contains a series of numbers separated by semicolons. For each mob that you want to ignore the deity passive making mobs non-aggressive to them, add 10 to their types list (be sure to separate with a semicolon). 

The 10 in the types corresponds to C_TYPE_HERD in Wurm Unlimited. To the best of my knowledge (and after asking for confirmation in WU modding discord) this field is unused by Wurm Unlimited. So instead of going through the hassle of creating an additional property, I just made use of it. That is why this mod is less than 50 lines long. If sometime in the future someone decides to also make use of this property, there could possibly be a conflict. But then you could tell them, that this mod was here first ;)

For specifics on custom creatures check out Tyoda's CustomCreature mod. (https://github.com/Tyoda/CustomCreatures)
