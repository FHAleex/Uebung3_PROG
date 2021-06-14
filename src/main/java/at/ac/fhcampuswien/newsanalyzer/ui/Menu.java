package at.ac.fhcampuswien.newsanalyzer.ui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class MenuEntry<T> {
	protected MenuEntry(String k, String t, T r) {
		key = k;
		text = t;
		element = r;
	}
	protected String key;
	protected String text;
	protected T element;
}

public class Menu<T> {

	private static final String NEW_LINE = "\n";
	
	private String title;
	
	private final List<MenuEntry<T>> menuEntries;

	Menu(String title) {
		menuEntries = new ArrayList<>();
		this.setTitle(title);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	void insert(String key, String text, T element) {
		menuEntries.add(new MenuEntry<>(key, text, element));
	}

	T exec() {
		System.out.println(NEW_LINE + NEW_LINE + title);
		for (int i = 0; i < title.length(); i++)
			System.out.print("*");
		
		System.out.print(NEW_LINE);
		menuEntries.forEach(m -> System.out.println(m.key + ")\t" + m.text));
		System.out.print(NEW_LINE);
		
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		do {
			String value = "\0";
			System.out.print(">");
			try {
				value = inReader.readLine();
			} catch (IOException e) {
				System.out.println("Error reading from cmd:" + e.toString());
				System.out.println(NEW_LINE);
				System.out.println("Exit with Ctrl C");
			}
			if (value.length() > 0) {
				for (MenuEntry<T> m : menuEntries)
					if (m.key.trim().equalsIgnoreCase(value.trim()))
						return m.element;

			}
			System.out.println("Wrong input");
		} while (true);
	}
	
	@Override
	public String toString() {
		return getTitle();
	}
}
