package main;

import test.StructureTest;

public abstract class Directories {

    private static final String novelDir = "Novel";
    private static final String novelFile = novelDir + "/novel.vnb";
    private static final String assetsDir = novelDir + "/assets";
    private static final String bgDir = assetsDir + "/bg";
    private static final String spriteDir = assetsDir + "/sprites";
    private static final String musicDir = assetsDir + "/music";
    private static final String sfxDir = assetsDir + "/sfx";

    static String getNovelFile() {
        return novelFile;
    }

    public static String getBgDir() {
        return bgDir;
    }

    public static String getSpriteDir() {
        return spriteDir;
    }

    public static String getSfxDir() {
        return sfxDir;
    }

    public static String getMusicDir() {
        return musicDir;
    }

    static void testStructure() {
        StructureTest.dirExists(novelDir);
        StructureTest.fileExists(novelFile);
        StructureTest.dirExists(assetsDir);
        StructureTest.dirExists(bgDir);
        StructureTest.dirExists(spriteDir);
        StructureTest.dirExists(musicDir);
        StructureTest.dirExists(sfxDir);
    }
}
