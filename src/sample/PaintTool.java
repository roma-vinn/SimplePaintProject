package sample;

import javafx.scene.input.MouseEvent;

/**
 * Interface for a paint tool.
 */
public interface PaintTool {

    /**
     * Callback upon mouse press.
     *
     * @param event Mouse event.
     * @param controller Controller of the painting.
     */
    void onMousePressed(MouseEvent event, Controller controller);

    /**
     * Callback upon mouse drag.
     *
     * @param event Mouse event.
     * @param controller Controller of the painting.
     */
    void onMouseDragged(MouseEvent event, Controller controller);

    /**
     * Callback upon mouse release
     *
     * @param event Mouse event.
     * @param controller Controller of the painting.
     */
    void onMouseReleased(MouseEvent event, Controller controller);

}
