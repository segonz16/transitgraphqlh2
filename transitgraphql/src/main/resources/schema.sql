DROP TABLE IF EXISTS infraccion;
DROP TABLE IF EXISTS matricula;
DROP TABLE IF EXISTS vehiculo;
DROP TABLE IF EXISTS propietario;

CREATE TABLE propietario (
    identificacion VARCHAR(50) PRIMARY KEY,
    tipo_propietario VARCHAR(20), -- Puede ser validado desde la lógica si H2 no soporta CHECK
    tipo_documento VARCHAR(20),
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255)
);

CREATE TABLE vehiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(20) -- Puede ser validado desde la lógica (Moto, Automovil, Carro Pesado)
);

CREATE TABLE matricula (
    placa VARCHAR(20) PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    fecha_matricula DATE NOT NULL,
    propietario_id VARCHAR(50),
    vehiculo_id INT,
    CONSTRAINT fk_matricula_propietario FOREIGN KEY (propietario_id) REFERENCES propietario(identificacion) ON DELETE SET NULL,
    CONSTRAINT fk_matricula_vehiculo FOREIGN KEY (vehiculo_id) REFERENCES vehiculo(id) ON DELETE CASCADE
);

CREATE TABLE infraccion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    accionada_por VARCHAR(20), -- Validar desde lógica ('Agente', 'Camara')
    placa VARCHAR(20),
    CONSTRAINT fk_infraccion_matricula FOREIGN KEY (placa) REFERENCES matricula(placa) ON DELETE CASCADE
);
