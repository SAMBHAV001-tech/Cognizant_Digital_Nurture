CREATE TABLE IF NOT EXISTS stock (
    st_id INT AUTO_INCREMENT PRIMARY KEY,
    st_code VARCHAR(10) NOT NULL,
    st_date DATE NOT NULL,
    st_open DECIMAL(10,2) NOT NULL,
    st_close DECIMAL(10,2) NOT NULL,
    st_volume BIGINT NOT NULL
);
