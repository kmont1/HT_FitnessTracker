package application;
	
import FitnessApp.FitnessApp;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

/**
 * 
 * @author Kmontasi
 *10.02.2022
 */

public class Main extends Application {
	
//	public void start(Stage primaryStage) {
//		try {
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("kirjautuminen.fxml"));
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//			
//			FitnessApp fitnessApp = new FitnessApp();
//			
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
		@Override
	public void start(Stage primaryStage) {
        try {
            final FXMLLoader ldr = new FXMLLoader(getClass().getResource("kirjautuminen.fxml"));
            final Pane root = (Pane)ldr.load();
            final LoginController kirjauduCtrl = (LoginController)ldr.getController();

            final Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("FitnessTracker");
            
            

            primaryStage.setOnCloseRequest((event) -> {
                    if ( !kirjauduCtrl.voikoSulkea() ) event.consume();
                });
            
            FitnessApp fitnessApp = new FitnessApp();  
            kirjauduCtrl.setFitnessApp(fitnessApp); 
            
            
            
           primaryStage.show();
//            if ( !kirjauduCtrl.avaa() ) Platform.exit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
