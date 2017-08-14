package engine;

import test.StructureTest;

public abstract class Directories {

    private static final String novelDir = "Novel";
    private static final String novelFile = novelDir + "/novel.vnb";
    private static final String assetsDir = novelDir + "/assets";
    private static final String backgroundImageDir = assetsDir + "/bg_image";
    private static final String foregroundImageDir = assetsDir + "/fg_image";
    private static final String musicDir = assetsDir + "/music";
    private static final String sfxDir = assetsDir + "/sfx";
    private static final String ambientSfxDir = assetsDir + "/ambient_sfx";

    static String getNovelFile() {
        return novelFile;
    }

    public static String getBackgroundImageDir() {
        return backgroundImageDir;
    }

    public static String getForegroundImageDir() {
        return foregroundImageDir;
    }

    public static String getSfxDir() {
        return sfxDir;
    }

    public static String getMusicDir() {
        return musicDir;
    }

    public static String getAmbientSfxDir() {
        return ambientSfxDir;
    }

    static void testStructure() {
        StructureTest.dirExists(novelDir);
        StructureTest.fileExists(novelFile);
        StructureTest.dirExists(assetsDir);
        StructureTest.dirExists(backgroundImageDir);
        StructureTest.dirExists(foregroundImageDir);
        StructureTest.dirExists(musicDir);
        StructureTest.dirExists(sfxDir);
        StructureTest.dirExists(ambientSfxDir);
    }
}
