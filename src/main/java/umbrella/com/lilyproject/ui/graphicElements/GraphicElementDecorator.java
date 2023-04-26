package umbrella.com.lilyproject.ui.graphicElements;

public abstract class GraphicElementDecorator implements Decoration{
	
	protected Decoration decoration;
	
	public GraphicElementDecorator(Decoration Decoration)
    {
        this.decoration = decoration;
    }
}
