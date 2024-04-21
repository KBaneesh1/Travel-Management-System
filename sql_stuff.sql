INSERT INTO car (vehicle_name, vehicle_type, price_per_day, capacity, driver_info, base_location, vehicle_image) 
VALUES 
('Toyota Corolla', 'car', 60.0, 5, 'seekesh ', 'Bengaluru', NULL),
('Honda Civic', 'car', 55.0, 5, 'Suresh', 'New Delhi', NULL),
('Ford Mustang', 'car', 70.0, 4, 'Ramesh ', 'Mumbai', NULL),
('Tesla Model S', 'car', 100.0, 4, 'Mahesh ', 'Chennai', NULL),
('BMW 3 Series', 'car', 80.0, 4, 'Lokesh ', 'Kolkata', NULL);


INSERT INTO transport(vehicle_name, vehicle_type, price_per_day, capacity, driver_info, base_location, vehicle_image) 
VALUES 
('Mercedes-Benz Sprinter', 'bus', 180.0, 40, 'Jane Smith', 'Himachal', NULL),
('Scania K-series', 'bus', 250.0, 60, 'Michael Johnson', 'Bangalore', NULL),
('Ashok Leyland Cheetah', 'bus', 150.0, 30, 'Emily Brown', 'Chennai', NULL),
('Volvo B7R', 'bus', 200.0, 50, 'John Doe', 'Mumbai', NULL),
('Tata Marcopolo', 'bus', 170.0, 35, 'David Lee', 'Kolkata', NULL);


INSERT INTO nonac_rooms (id, price_per_night, amenities, hotel_id, num_rooms, room_type) 
VALUES 
(1, 1700, 'Breakfast', 1, 25, 'Non-AC Room'),
(6, 3000, 'Wi-Fi', 3, 10, 'Non-AC Room'),
(7, 2000, 'Wi-Fi', 4, 15, 'Non-AC Room'),
(8, 2800, 'Wi-Fi, Lighthouse tour', 5, 20, 'Non-AC Room'),
(9, 1500, 'Wifi', 6, 10, 'Non-AC Room'),
(10, 2000, 'Wi-Fi', 7, 15, 'Non-AC Room');


INSERT INTO hotels (id, address, hotel_name, base_location) 
VALUES (7, 'Pondicherry', 'Java Resort', 'Pondicherry');

INSERT INTO transport(vehicle_name, vehicle_type, price_per_day, capacity, driver_info, base_location, vehicle_image) 
VALUES 
('Tata Indica', 'bus', 150.0, 30, 'Emily Brown', 'Himachal', NULL);
