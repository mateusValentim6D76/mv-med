CREATE TABLE IF NOT EXISTS medical_registration (
    id UUID DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    crm VARCHAR(20) NOT NULL,
    specialty VARCHAR(50) NOT NULL,
    public_place VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    zip_code VARCHAR(20) NOT NULL,
    city VARCHAR(100) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    number INTEGER NOT NULL,
    complement VARCHAR(255),
    PRIMARY KEY (id)
);
