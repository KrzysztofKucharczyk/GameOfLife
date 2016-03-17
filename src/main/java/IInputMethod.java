public interface IInputMethod<E> {
	public E getInput();
	public boolean hasNext();
	public void closeInput();
}
