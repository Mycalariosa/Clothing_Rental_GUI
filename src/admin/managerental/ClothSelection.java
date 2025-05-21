package admin.managerental;

public class ClothSelection {
    public static String selectedImagePath;
    public static String selectedName;
    public static String selectedCategory;
    public static String selectedPrice;
    public static int selectedClothId;
    
    // Method to set the selected cloth details
    public static void setSelectedCloth(String imagePath, String name, String category, String price, int clothId) {
        selectedImagePath = imagePath;
        selectedName = name;
        selectedCategory = category;
        selectedPrice = price;
        selectedClothId = clothId;
    }
    
    // Method to clear the selection
    public static void clearSelection() {
        selectedImagePath = null;
        selectedName = null;
        selectedCategory = null;
        selectedPrice = null;
        selectedClothId = -1;
    }
} 