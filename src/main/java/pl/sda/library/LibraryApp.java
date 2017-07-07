package pl.sda.library;

import javax.swing.SwingUtilities;

import pl.sda.library.view.AppView;

public class LibraryApp {

	public static void main(String[] args) {
		//invoke later przyjmuje watek
		//jest ona wywolywana w momencie kiedy aplikacja otrzymuje kontrole
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void createAndShowGUI() throws Exception {
		new AppView();
	}

}
