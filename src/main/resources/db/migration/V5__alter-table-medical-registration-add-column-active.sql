ALTER TABLE medical_registration
ADD COLUMN active BOOLEAN ;
UPDATE medical_registration SET active = true
