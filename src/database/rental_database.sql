USE mbatelier;

-- Drop existing tables and views if they exist
DROP TABLE IF EXISTS rentals;
DROP VIEW IF EXISTS available_items_view;
DROP VIEW IF EXISTS active_rentals_view;

-- Create rentals table
CREATE TABLE rentals (
    rental_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    customer_phone VARCHAR(20) NOT NULL,
    clothes_id INT NOT NULL,
    rental_date DATE NOT NULL,
    return_date DATE NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    status ENUM('active', 'returned') DEFAULT 'active',
    FOREIGN KEY (clothes_id) REFERENCES clothes(clothesid)
);

-- Create view for available items
CREATE VIEW available_items_view AS
SELECT 
    clothesid,
    clothname as name,
    description,
    sizes as size,
    category,
    price as daily_rate,
    photo_path as image_path
FROM clothes
WHERE availability = 'Available';

-- Create view for active rentals
CREATE VIEW active_rentals_view AS
SELECT 
    r.rental_id,
    r.customer_name,
    r.customer_phone,
    c.clothname as item_name,
    r.rental_date,
    r.return_date,
    r.total_amount,
    r.status
FROM rentals r
JOIN clothes c ON r.clothes_id = c.clothesid
WHERE r.status = 'active'; 