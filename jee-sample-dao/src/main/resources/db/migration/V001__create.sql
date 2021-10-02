CREATE TABLE categories (
	category_id INT PRIMARY KEY,
	category_name VARCHAR (255) NOT NULL,
	category_uuid VARCHAR (40)
);

CREATE TABLE brands (
	brand_id INT PRIMARY KEY,
	brand_name VARCHAR (255) NOT NULL
);

CREATE TABLE products (
	product_id INT PRIMARY KEY,
	product_name VARCHAR (255) NOT NULL,
	brand_id INT NOT NULL,
	category_id INT NOT NULL,
	model_year SMALLINT NOT NULL,
	list_price DECIMAL (10, 2) NOT NULL,
	FOREIGN KEY (category_id) REFERENCES categories (category_id),
	FOREIGN KEY (brand_id) REFERENCES brands (brand_id)
);
