package Scenes;

public enum GameScene {
    MMenu, InGame;
    private static GameScene currentGameScene = MMenu;
    public static GameScene getCurrentGameScene() {
        return currentGameScene;
    }
    public static void setCurrentGameScene(GameScene requiredGameScene) {
        GameScene.currentGameScene = requiredGameScene;
    }
}
