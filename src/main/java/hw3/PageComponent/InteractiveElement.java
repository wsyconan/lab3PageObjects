package hw3.PageComponent;

public interface InteractiveElement {
    void select(String name);
    boolean isSelected(String name) throws Exception;
}
