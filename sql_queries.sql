-- 10 insertion statements
INSERT INTO `building`.`states` (`state_id`, `name`) VALUES ('5', 'California');
INSERT INTO `building`.`cities` (`city_id`, `name`, `state_id`) VALUES ('2', 'Phoenix', '3');
INSERT INTO `building`.`jobs` (`job_id`, `job_title`) VALUES ('2', 'Civil Engineer');
INSERT INTO `building`.`employees` (emp_id, first_name, last_name, age, email, phone_number, job_id) values (1, 'Gene', 'Bassett', 33, 'gbassett0@myspace.com', '8802432507', 1);
INSERT INTO `building`.`clients` (client_id, first_name, last_name, email, phone_number) values (2, 'Cecily', 'Fullun', 'cfullun1@weibo.com', '5553929469');
INSERT INTO `building`.`teams` (`team_id`, `team_name`) VALUES ('1', 'Team A');
INSERT INTO `building`.`emp_teams` (`emp_id`, `team_id`) VALUES ('11', '2');
INSERT INTO `building`.`phases` (`phase_id`, `phase_name`) VALUES ('1', 'Initiation');
INSERT INTO `building`.`building_type` (`building_type_id`, `building_name`) VALUES ('2', 'Office');
INSERT INTO `building`.`materials` (`material_id`, `material_name`, `material_desc`, `material_price`) VALUES ('1', 'Wood', '1 cord of wood', '500');

-- 10 update statments
UPDATE `building`.`jobs` SET `job_title` = 'Cost Estimator' WHERE (`job_id` = '3');
UPDATE `building`.`jobs` SET `job_title` = 'Safety Manager' WHERE (`job_id` = '4');
UPDATE `building`.`clients` SET `company_name` = 'City of San Jose' WHERE (`client_id` = '3');
UPDATE `building`.`employees` SET `job_id` = '3' WHERE (`emp_id` = '9');
UPDATE `building`.`projects` SET `site_id` = '1' WHERE (`project_id` = '1');
UPDATE `building`.`packages` SET `status` = 'Invoiced' WHERE (`package_id` = '1');
UPDATE `building`.`projects` SET `project_name` = 'Homeland', `building_type` = '4' WHERE (`project_id` = '1');
UPDATE `building`.`projects` SET `project_name` = 'Project Z', `building_type` = '2' WHERE (`project_id` = '2');
UPDATE `building`.`client_projects` SET `client_id` = '4' WHERE (`client_id` = '2') and (`project_id` = '1');
UPDATE `building`.`package_details` SET `quantity` = '9' WHERE (`package_id` = '1') and (`material_id` = '4');

-- 10 deletion statements
DELETE FROM `building`.`building_type` WHERE (`building_type_id` = '5');
DELETE FROM `building`.`cities` WHERE (`city_id` = '6');
DELETE FROM `building`.`client_projects` WHERE (`client_id` = '2') and (`project_id` = '1');
DELETE FROM `building`.`clients` WHERE (`client_id` = '6');
DELETE FROM `building`.`emp_teams` WHERE (`emp_id` = '1') and (`team_id` = '2');
DELETE FROM `building`.`employees` WHERE (`emp_id` = '13');
DELETE FROM `building`.`jobs` WHERE (`job_id` = '7');
DELETE FROM `building`.`materials` WHERE (`material_id` = '7');
DELETE FROM `building`.`package_details` WHERE (`package_id` = '1') and (`material_id` = '2');
DELETE FROM `building`.`phases` WHERE (`phase_id` = '6');

-- 5 alter table
ALTER TABLE `building`.`employees` 
CHANGE COLUMN `phone_number` `phone_number` VARCHAR(15) NOT NULL ;
ALTER TABLE `building`.`clients` 
ADD COLUMN `last_name` VARCHAR(45) NOT NULL AFTER `first_name`,
ADD COLUMN `email` VARCHAR(45) NOT NULL AFTER `last_name`,
ADD COLUMN `company_name` VARCHAR(45) NULL AFTER `email`,
CHANGE COLUMN `client_name` `first_name` VARCHAR(45) NOT NULL ;
ALTER TABLE `building`.`projects` 
ADD INDEX `fk_project_btype_idx` (`building_type` ASC) VISIBLE;
;
ALTER TABLE `building`.`projects` 
ADD CONSTRAINT `fk_project_btype`
  FOREIGN KEY (`building_type`)
  REFERENCES `building`.`building_type` (`building_type_id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
ALTER TABLE `building`.`packages` 
DROP COLUMN `total_price`,
CHANGE COLUMN `comments` `status` VARCHAR(45) NOT NULL ;
ALTER TABLE `building`.`teams` 
ADD COLUMN `team_details` VARCHAR(45) NULL AFTER `team_name`;

-- big join statement
SELECT projects.project_id, clients.first_name, clients.last_name, project_name, building_name, phase_name, site.site_id, zip, cities.name, states.name, packages.package_id, material_name, quantity, teams.team_name, employees.first_name, employees.last_name, job_title FROM projects
LEFT JOIN building_type ON projects.building_type = building_type.building_type_id
LEFT JOIN phases ON projects.phase_id = phases.phase_id
LEFT JOIN site ON projects.site_id = site.site_id
LEFT JOIN cities ON site.city_id = cities.city_id
LEFT JOIN states ON cities.state_id = states.state_id
LEFT JOIN packages ON site.site_id = packages.site_id
LEFT JOIN package_details ON packages.package_id = package_details.package_id
LEFT JOIN materials ON package_details.material_id = materials.material_id
LEFT JOIN client_projects ON projects.project_id = client_projects.project_id
LEFT JOIN clients ON client_projects.client_id = clients.client_id
LEFT JOIN teams ON projects.team_id = teams.team_id
LEFT JOIN emp_teams ON teams.team_id = emp_teams.team_id
LEFT JOIN employees ON emp_teams.emp_id = employees.emp_id
LEFT JOIN jobs ON employees.job_id = jobs.job_id;

-- 5 statements with left outer join
SELECT employees.first_name, employees.last_name, emp_teams.team_id
FROM employees
LEFT JOIN emp_teams ON employees.emp_id = emp_teams.emp_id;
SELECT job_title, first_name, last_name
FROM jobs
LEFT JOIN employees ON jobs.job_id = employees.job_id;
SELECT cities.name, states.name
FROM cities
LEFT JOIN states ON cities.state_id = states.state_id;
SELECT site.site_id, site.address, name
FROM site
LEFT JOIN cities ON site.city_id = cities.city_id;
SELECT project_name, phase_, building_name
FROM projects
LEFT JOIN building_type ON projects.building_type = building_type.building_type_id;

-- 5 statements with right outer join
SELECT cities.name, site_id, site.address
FROM site
RIGHT JOIN cities ON site.city_id = cities.city_id;
SELECT clients.first_name, clients.last_name, client_projects.project_id
FROM client_projects
RIGHT JOIN clients ON client_projects.client_id = clients.client_id;
SELECT jobs.job_title, employees.emp_id, employees.age
FROM employees
RIGHT JOIN jobs ON employees.job_id = jobs.job_id;
SELECT team_name, project_name
FROM projects
RIGHT JOIN teams ON projects.team_id = teams.team_id;
SELECT material_name, package_id, quantity
FROM package_details
RIGHT JOIN materials ON package_details.material_id = materials.material_id;

-- 5 statements with inner join
SELECT first_name, last_name, team_id
FROM employees
INNER JOIN emp_teams ON employees.emp_id = emp_teams.emp_id;
SELECT cities.name, states.name
FROM cities
INNER JOIN states ON cities.state_id = states.state_id;
SELECT packages.package_id, package_details.material_id, package_details.quantity
FROM packages
INNER JOIN package_details ON packages.package_id = package_details.package_id;
SELECT team_name, emp_id
FROM teams
INNER JOIN emp_teams ON teams.team_id = emp_teams.team_id;
SELECT site.site_id, packages.package_id, project_name
FROM site
INNER JOIN packages ON site.site_id = packages.site_id
INNER JOIN projects ON site.site_id = projects.project_id;

-- 7 statements with aggregate functions and group by and without having
SELECT min(age), job_id
FROM employees
GROUP BY job_id;
SELECT count(emp_id), job_id
FROM employees
GROUP BY job_id;
SELECT avg(material_price), material_desc
FROM materials
group by material_desc;
SELECT sum(material_price * package_details.quantity), package_id
FROM materials
INNER JOIN package_details ON materials.material_id = package_details.material_id
group by package_id;
SELECT max(age), job_id
FROM employees
GROUP BY job_id;
SELECT sum(material_price), material_desc
FROM materials
group by material_desc;
SELECT sum(package_details.quantity), package_id
FROM package_details
group by package_id;

-- 7 statements with aggregate functions and group by and with having
SELECT COUNT(emp_id), job_id
FROM employees
GROUP BY job_id
HAVING min(age) > 30;
SELECT count(emp_id), team_id
FROM emp_teams
GROUP BY team_id
HAVING count(emp_id) >= 6;
SELECT material_id
FROM package_details
GROUP BY material_id
HAVING sum(quantity) > 10;
SELECT count(project_id), team_id
FROM projects
GROUP BY team_id
HAVING team_id = 1;
SELECT COUNT(emp_id), job_id, age
FROM employees
GROUP BY emp_id
HAVING age > 30;
SELECT avg(age), job_id
FROM employees
GROUP BY job_id
HAVING job_id < 5;
SELECT COUNT(project_id), building_type
FROM projects
GROUP BY building_type
HAVING building_type = 2