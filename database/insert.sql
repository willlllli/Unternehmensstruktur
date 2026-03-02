@include create.sql

SET search_path TO Unternehmensstruktur, public;

-- Adressen für Firmen
INSERT INTO Adresse (Strasse, Hausnummer, PLZ, Stadt, Bundesland, Land_iso)
VALUES
  ('Friedrich-Ebert-Allee',  '140',  53113, 'Bonn',             'Nordrhein-Westfalen', 'DE'),
  ('Landgrabenweg',          '151',  53227, 'Bonn',             'Nordrhein-Westfalen', 'DE'),
  ('Hahnstraße',             '43d',  60528, 'Frankfurt am Main','Hessen',              'DE'),
  ('Bayenwerft',             '12-14',50678, 'Köln',             'Nordrhein-Westfalen', 'DE'),
  ('Riesaer Straße',         '5',    01129, 'Dresden',          'Sachsen',             'DE'),
  ('Landgrabenweg',          '149',  53227, 'Bonn',             'Nordrhein-Westfalen', 'DE'),
('Unter den Linden',         '1',    10117, 'Berlin',               'Berlin',                  'DE'),
('Alexanderplatz',           '5',    10178, 'Berlin',               'Berlin',                  'DE'),
('Mönckebergstraße',         '7',    20095, 'Hamburg',              'Hamburg',                 'DE'),
('Reeperbahn',               '42',   20359, 'Hamburg',              'Hamburg',                 'DE'),
('Marienplatz',              '1',    80331, 'München',              'Bayern',                  'DE'),
('Leopoldstraße',            '25',   80802, 'München',              'Bayern',                  'DE'),
('Königstraße',              '1A',   70173, 'Stuttgart',            'Baden-Württemberg',       'DE'),
('Rotebühlplatz',            '30',   70178, 'Stuttgart',            'Baden-Württemberg',       'DE'),
('Königsallee',              '1',    40212, 'Düsseldorf',           'Nordrhein-Westfalen',     'DE'),
('Graf-Adolf-Straße',        '14',   40212, 'Düsseldorf',           'Nordrhein-Westfalen',     'DE'),
('Augustusplatz',            '10',    4109, 'Leipzig',              'Sachsen',                 'DE'),
('Karl-Liebknecht-Straße',   '44',    4275, 'Leipzig',              'Sachsen',                 'DE'),
('Westenhellweg',            '1',    44137, 'Dortmund',             'Nordrhein-Westfalen',     'DE'),
('Rheinlanddamm',            '199',  44139, 'Dortmund',             'Nordrhein-Westfalen',     'DE'),
('Kettwiger Straße',         '2',    45127, 'Essen',                'Nordrhein-Westfalen',     'DE'),
('Am Markt',                 '21',   28195, 'Bremen',               'Bremen',                  'DE'),
('Georgstraße',              '8',    30159, 'Hannover',             'Niedersachsen',           'DE'),
('Hauptmarkt',               '1',    90402, 'Nürnberg',             'Bayern',                  'DE'),
('Prinzipalmarkt',           '10',   48143, 'Münster',              'Nordrhein-Westfalen',     'DE'),
('Kaiserstraße',             '12',   76133, 'Karlsruhe',            'Baden-Württemberg',       'DE'),
('Planken',                  '1',    68161, 'Mannheim',             'Baden-Württemberg',       'DE'),
('Maximilianstraße',         '15',   86150, 'Augsburg',             'Bayern',                  'DE'),
('Wilhelmstraße',            '24',   65183, 'Wiesbaden',            'Hessen',                  'DE'),
('Bohlweg',                  '25',   38100, 'Braunschweig',         'Niedersachsen',           'DE'),
('Adalbertstraße',           '6',    52062, 'Aachen',               'Nordrhein-Westfalen',     'DE'),
('Holstenstraße',            '1',    24103, 'Kiel',                 'Schleswig-Holstein',      'DE'),
('Markt',                    '1',     9111, 'Chemnitz',             'Sachsen',                 'DE'),
('Fischmarkt',               '1',    99084, 'Erfurt',               'Thüringen',               'DE'),
('Neuer Markt',              '1',    18055, 'Rostock',              'Mecklenburg-Vorpommern',  'DE'),
('Alter Markt',              '13',   39104, 'Magdeburg',            'Sachsen-Anhalt',          'DE'),
('Lessingstraße', '1a', 50667, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Seestraße', '2', 50823, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Brunnenweg', '3', 51063, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Schulstraße', '4', 50733, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Uhlandstraße', '5', 50668, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Mühlenweg', '6', 60435, 'Frankfurt am Main', 'Hessen', 'DE'),
('Poststraße', '7', 60318, 'Frankfurt am Main', 'Hessen', 'DE'),
('Waldstraße', '8a', 60433, 'Frankfurt am Main', 'Hessen', 'DE'),
('Gartenstraße', '9', 60325, 'Frankfurt am Main', 'Hessen', 'DE'),
('Humboldtstraße', '10', 60327, 'Frankfurt am Main', 'Hessen', 'DE'),
('Fichtenweg', '11', 60322, 'Frankfurt am Main', 'Hessen', 'DE'),
('Lutherstraße', '12b', 81371, 'München', 'Bayern', 'DE'),
('Wilhelmstraße', '13', 81669, 'München', 'Bayern', 'DE'),
('Bergstraße', '14', 81541, 'München', 'Bayern', 'DE'),
('Friedrichstraße', '15a', 81377, 'München', 'Bayern', 'DE'),
('Hainstraße', '16', 80331, 'München', 'Bayern', 'DE'),
('Sonnenstraße', '17', 4177, 'Leipzig', 'Sachsen', 'DE'),
('Goethestraße', '18c', 4105, 'Leipzig', 'Sachsen', 'DE'),
('Kirchweg', '19', 4107, 'Leipzig', 'Sachsen', 'DE'),
('Heimstraße', '20', 4103, 'Leipzig', 'Sachsen', 'DE'),
('Klosterstraße', '21', 4275, 'Leipzig', 'Sachsen', 'DE'),
('Ringstraße', '22a', 99098, 'Erfurt', 'Thüringen', 'DE'),
('Ahornstraße', '23b', 99092, 'Erfurt', 'Thüringen', 'DE'),
('Tannenweg', '24', 99088, 'Erfurt', 'Thüringen', 'DE'),
('Eichenallee', '25', 99089, 'Erfurt', 'Thüringen', 'DE'),
('Buchenstraße', '26', 99084, 'Erfurt', 'Thüringen', 'DE'),
('Kastanienallee', '27', 65191, 'Wiesbaden', 'Hessen', 'DE'),
('Maxstraße', '28', 65183, 'Wiesbaden', 'Hessen', 'DE'),
('Feldstraße', '29a', 65197, 'Wiesbaden', 'Hessen', 'DE'),
('Dorfstraße', '30', 52066, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Lindenstraße', '31', 52064, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Blumenstraße', '32', 52068, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Schubertstraße', '33', 52076, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Wiesenweg', '34b', 52078, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Hauptstraße', '35c', 52062, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Brückenstraße', '36a', 44137, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Fichtestraße', '37', 44143, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Zeppelinstraße', '38', 44139, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Elisabethstraße', '39', 1219, 'Dresden', 'Sachsen', 'DE'),
('Bahnhofstraße', '40', 1169, 'Dresden', 'Sachsen', 'DE'),
('Marktstraße', '41', 1069, 'Dresden', 'Sachsen', 'DE'),
('Birkenweg', '42', 1129, 'Dresden', 'Sachsen', 'DE'),
('Rosenstraße', '43a', 22083, 'Hamburg', 'Hamburg', 'DE'),
('Tulpenweg', '44', 22041, 'Hamburg', 'Hamburg', 'DE'),
('Mozartstraße', '45b', 20095, 'Hamburg', 'Hamburg', 'DE'),
('Beethovenstraße', '46', 20359, 'Hamburg', 'Hamburg', 'DE'),
('Schillerstraße', '47', 39120, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Heinestraße', '48', 39114, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Herderstraße', '49', 39110, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Kantstraße', '50a', 39104, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Hegelstraße', '51', 39124, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Rembrandtstraße', '52c', 9111, 'Chemnitz', 'Sachsen', 'DE'),
('Dürerstraße', '53', 9122, 'Chemnitz', 'Sachsen', 'DE'),
('Keplerstraße', '54', 9130, 'Chemnitz', 'Sachsen', 'DE'),
('Kopernikusstraße', '55', 45141, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Einsteinstraße', '56b', 45130, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Neustraße', '57a', 45131, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Alte Straße', '58', 45136, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Kirchgasse', '59', 45127, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Dammstraße', '60', 68219, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Wiesenstraße', '61', 68167, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Lessingstraße', '62', 68169, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Seestraße', '63', 68161, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Brunnenweg', '64a', 24116, 'Kiel', 'Schleswig-Holstein', 'DE'),
('Schulstraße', '65', 24103, 'Kiel', 'Schleswig-Holstein', 'DE'),
('Uhlandstraße', '66', 48153, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Mühlenweg', '67b', 48145, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Poststraße', '68', 48165, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Waldstraße', '69c', 48143, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Gartenstraße', '70', 38110, 'Braunschweig', 'Niedersachsen', 'DE'),
('Humboldtstraße', '71a', 38100, 'Braunschweig', 'Niedersachsen', 'DE'),
('Fichtenweg', '72', 18106, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Lutherstraße', '73', 18057, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Wilhelmstraße', '74', 18146, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Bergstraße', '75', 18055, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Friedrichstraße', '76', 70190, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Hainstraße', '77', 70173, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Sonnenstraße', '78a', 70376, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Goethestraße', '79', 70378, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Kirchweg', '80', 70178, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Heimstraße', '81', 90402, 'Nürnberg', 'Bayern', 'DE'),
('Klosterstraße', '82', 90403, 'Nürnberg', 'Bayern', 'DE'),
('Ringstraße', '83', 90408, 'Nürnberg', 'Bayern', 'DE'),
('Ahornstraße', '84', 10707, 'Berlin', 'Berlin', 'DE'),
('Tannenweg', '85a', 10365, 'Berlin', 'Berlin', 'DE'),
('Eichenallee', '86c', 10243, 'Berlin', 'Berlin', 'DE'),
('Buchenstraße', '87', 10117, 'Berlin', 'Berlin', 'DE'),
('Kastanienallee', '88', 10178, 'Berlin', 'Berlin', 'DE'),
('Maxstraße', '89b', 10245, 'Berlin', 'Berlin', 'DE'),
('Feldstraße', '90', 10405, 'Berlin', 'Berlin', 'DE'),
('Dorfstraße', '91', 86179, 'Augsburg', 'Bayern', 'DE'),
('Lindenstraße', '92a', 86153, 'Augsburg', 'Bayern', 'DE'),
('Blumenstraße', '93', 86154, 'Augsburg', 'Bayern', 'DE'),
('Schubertstraße', '94', 86150, 'Augsburg', 'Bayern', 'DE'),
('Wiesenweg', '95', 30163, 'Hannover', 'Niedersachsen', 'DE'),
('Hauptstraße', '96', 30177, 'Hannover', 'Niedersachsen', 'DE'),
('Brückenstraße', '97', 30159, 'Hannover', 'Niedersachsen', 'DE'),
('Fichtestraße', '98', 30167, 'Hannover', 'Niedersachsen', 'DE'),
('Zeppelinstraße', '99a', 53115, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Elisabethstraße', '100b', 53113, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Bahnhofstraße', '101', 53227, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Marktstraße', '102', 53119, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Birkenweg', '103c', 28201, 'Bremen', 'Bremen', 'DE'),
('Rosenstraße', '104', 28219, 'Bremen', 'Bremen', 'DE'),
('Tulpenweg', '105', 28195, 'Bremen', 'Bremen', 'DE'),
('Mozartstraße', '106a', 28203, 'Bremen', 'Bremen', 'DE'),
('Beethovenstraße', '107', 40212, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Schillerstraße', '108', 40211, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Heinestraße', '109', 40215, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Herderstraße', '110', 40221, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Kantstraße', '111b', 76133, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Hegelstraße', '112', 76137, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Rembrandtstraße', '113a', 76187, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Dürerstraße', '114', 76149, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Keplerstraße', '115', 50667, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Kopernikusstraße', '116', 50823, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Einsteinstraße', '117', 51063, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Neustraße', '118', 50733, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Alte Straße', '119', 50668, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Kirchgasse', '1a', 60435, 'Frankfurt am Main', 'Hessen', 'DE'),
('Dammstraße', '2', 60318, 'Frankfurt am Main', 'Hessen', 'DE'),
('Wiesenstraße', '3b', 60433, 'Frankfurt am Main', 'Hessen', 'DE'),
('Lessingstraße', '4', 60325, 'Frankfurt am Main', 'Hessen', 'DE'),
('Seestraße', '5', 60327, 'Frankfurt am Main', 'Hessen', 'DE'),
('Brunnenweg', '6', 60322, 'Frankfurt am Main', 'Hessen', 'DE'),
('Schulstraße', '7', 81371, 'München', 'Bayern', 'DE'),
('Uhlandstraße', '8a', 81669, 'München', 'Bayern', 'DE'),
('Mühlenweg', '9', 81541, 'München', 'Bayern', 'DE'),
('Poststraße', '10', 81377, 'München', 'Bayern', 'DE'),
('Waldstraße', '11', 80331, 'München', 'Bayern', 'DE'),
('Gartenstraße', '12', 4177, 'Leipzig', 'Sachsen', 'DE'),
('Humboldtstraße', '13', 4105, 'Leipzig', 'Sachsen', 'DE'),
('Fichtenweg', '14b', 4107, 'Leipzig', 'Sachsen', 'DE'),
('Lutherstraße', '15a', 4103, 'Leipzig', 'Sachsen', 'DE'),
('Wilhelmstraße', '16', 4275, 'Leipzig', 'Sachsen', 'DE'),
('Bergstraße', '17', 99098, 'Erfurt', 'Thüringen', 'DE'),
('Friedrichstraße', '18c', 99092, 'Erfurt', 'Thüringen', 'DE'),
('Hainstraße', '19', 99088, 'Erfurt', 'Thüringen', 'DE'),
('Sonnenstraße', '20', 99089, 'Erfurt', 'Thüringen', 'DE'),
('Goethestraße', '21', 99084, 'Erfurt', 'Thüringen', 'DE'),
('Kirchweg', '22a', 65191, 'Wiesbaden', 'Hessen', 'DE'),
('Heimstraße', '23', 65183, 'Wiesbaden', 'Hessen', 'DE'),
('Klosterstraße', '24', 65197, 'Wiesbaden', 'Hessen', 'DE'),
('Ringstraße', '25b', 52066, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Ahornstraße', '26', 52064, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Tannenweg', '27', 52068, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Eichenallee', '28', 52076, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Buchenstraße', '29a', 52078, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Kastanienallee', '30', 52062, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Maxstraße', '31', 44137, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Feldstraße', '32', 44143, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Dorfstraße', '33', 44139, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Lindenstraße', '34', 1219, 'Dresden', 'Sachsen', 'DE'),
('Blumenstraße', '35c', 1169, 'Dresden', 'Sachsen', 'DE'),
('Schubertstraße', '36a', 1069, 'Dresden', 'Sachsen', 'DE'),
('Wiesenweg', '37', 1129, 'Dresden', 'Sachsen', 'DE'),
('Hauptstraße', '38', 22083, 'Hamburg', 'Hamburg', 'DE'),
('Brückenstraße', '39', 22041, 'Hamburg', 'Hamburg', 'DE'),
('Fichtestraße', '40', 20095, 'Hamburg', 'Hamburg', 'DE'),
('Zeppelinstraße', '41', 20359, 'Hamburg', 'Hamburg', 'DE'),
('Elisabethstraße', '42', 39120, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Bahnhofstraße', '43a', 39114, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Marktstraße', '44', 39110, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Birkenweg', '45', 39104, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Rosenstraße', '46', 39124, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Tulpenweg', '47b', 9111, 'Chemnitz', 'Sachsen', 'DE'),
('Mozartstraße', '48', 9122, 'Chemnitz', 'Sachsen', 'DE'),
('Beethovenstraße', '49', 9130, 'Chemnitz', 'Sachsen', 'DE'),
('Schillerstraße', '50a', 45141, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Heinestraße', '51', 45130, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Herderstraße', '52c', 45131, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Kantstraße', '53', 45136, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Hegelstraße', '54', 45127, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Rembrandtstraße', '55', 68219, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Dürerstraße', '56', 68167, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Keplerstraße', '57a', 68169, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Kopernikusstraße', '58b', 68161, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Einsteinstraße', '59', 24116, 'Kiel', 'Schleswig-Holstein', 'DE'),
('Neustraße', '60', 24103, 'Kiel', 'Schleswig-Holstein', 'DE'),
('Alte Straße', '61', 48153, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Kirchgasse', '62', 48145, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Dammstraße', '63', 48165, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Wiesenstraße', '64a', 48143, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Lessingstraße', '65', 38110, 'Braunschweig', 'Niedersachsen', 'DE'),
('Seestraße', '66', 38100, 'Braunschweig', 'Niedersachsen', 'DE'),
('Brunnenweg', '67', 18106, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Schulstraße', '68', 18057, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Uhlandstraße', '69b', 18146, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Mühlenweg', '70', 18055, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Poststraße', '71a', 70190, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Waldstraße', '72', 70173, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Gartenstraße', '73', 70376, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Humboldtstraße', '74', 70378, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Fichtenweg', '75', 70178, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Lutherstraße', '76', 90402, 'Nürnberg', 'Bayern', 'DE'),
('Wilhelmstraße', '77', 90403, 'Nürnberg', 'Bayern', 'DE'),
('Bergstraße', '78a', 90408, 'Nürnberg', 'Bayern', 'DE'),
('Friedrichstraße', '79', 10707, 'Berlin', 'Berlin', 'DE'),
('Hainstraße', '80b', 10365, 'Berlin', 'Berlin', 'DE'),
('Sonnenstraße', '81', 10243, 'Berlin', 'Berlin', 'DE'),
('Goethestraße', '82', 10117, 'Berlin', 'Berlin', 'DE'),
('Kirchweg', '83', 10178, 'Berlin', 'Berlin', 'DE'),
('Heimstraße', '84', 10245, 'Berlin', 'Berlin', 'DE'),
('Klosterstraße', '85a', 10405, 'Berlin', 'Berlin', 'DE'),
('Ringstraße', '86c', 86179, 'Augsburg', 'Bayern', 'DE'),
('Ahornstraße', '87', 86153, 'Augsburg', 'Bayern', 'DE'),
('Tannenweg', '88', 86154, 'Augsburg', 'Bayern', 'DE'),
('Eichenallee', '89', 86150, 'Augsburg', 'Bayern', 'DE'),
('Buchenstraße', '90', 30163, 'Hannover', 'Niedersachsen', 'DE'),
('Kastanienallee', '91b', 30177, 'Hannover', 'Niedersachsen', 'DE'),
('Maxstraße', '92a', 30159, 'Hannover', 'Niedersachsen', 'DE'),
('Feldstraße', '93', 30167, 'Hannover', 'Niedersachsen', 'DE'),
('Dorfstraße', '94', 53115, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Lindenstraße', '95', 53113, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Blumenstraße', '96', 53227, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Schubertstraße', '97', 53119, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Wiesenweg', '98', 28201, 'Bremen', 'Bremen', 'DE'),
('Hauptstraße', '99a', 28219, 'Bremen', 'Bremen', 'DE'),
('Brückenstraße', '100', 28195, 'Bremen', 'Bremen', 'DE'),
('Fichtestraße', '101', 28203, 'Bremen', 'Bremen', 'DE'),
('Zeppelinstraße', '102b', 40212, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Elisabethstraße', '103c', 40211, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Bahnhofstraße', '104', 40215, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Marktstraße', '105', 40221, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Birkenweg', '106a', 76133, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Rosenstraße', '107', 76137, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Tulpenweg', '108', 76187, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Mozartstraße', '109', 76149, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Beethovenstraße', '110', 50667, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Schillerstraße', '111', 50823, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Heinestraße', '112', 51063, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Herderstraße', '113a', 50733, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Kantstraße', '114', 50668, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Hegelstraße', '115', 60435, 'Frankfurt am Main', 'Hessen', 'DE'),
('Rembrandtstraße', '116', 60318, 'Frankfurt am Main', 'Hessen', 'DE'),
('Dürerstraße', '117', 60433, 'Frankfurt am Main', 'Hessen', 'DE'),
('Keplerstraße', '118', 60325, 'Frankfurt am Main', 'Hessen', 'DE'),
('Kopernikusstraße', '119', 60327, 'Frankfurt am Main', 'Hessen', 'DE'),
('Einsteinstraße', '1a', 60322, 'Frankfurt am Main', 'Hessen', 'DE'),
('Neustraße', '2', 81371, 'München', 'Bayern', 'DE'),
('Alte Straße', '3', 81669, 'München', 'Bayern', 'DE'),
('Kirchgasse', '4', 81541, 'München', 'Bayern', 'DE'),
('Dammstraße', '5b', 81377, 'München', 'Bayern', 'DE'),
('Wiesenstraße', '6', 80331, 'München', 'Bayern', 'DE'),
('Lessingstraße', '7', 4177, 'Leipzig', 'Sachsen', 'DE'),
('Seestraße', '8a', 4105, 'Leipzig', 'Sachsen', 'DE'),
('Brunnenweg', '9', 4107, 'Leipzig', 'Sachsen', 'DE'),
('Schulstraße', '10', 4103, 'Leipzig', 'Sachsen', 'DE'),
('Uhlandstraße', '11', 4275, 'Leipzig', 'Sachsen', 'DE'),
('Mühlenweg', '12', 99098, 'Erfurt', 'Thüringen', 'DE'),
('Poststraße', '13', 99092, 'Erfurt', 'Thüringen', 'DE'),
('Waldstraße', '14', 99088, 'Erfurt', 'Thüringen', 'DE'),
('Gartenstraße', '15a', 99089, 'Erfurt', 'Thüringen', 'DE'),
('Humboldtstraße', '16b', 99084, 'Erfurt', 'Thüringen', 'DE'),
('Fichtenweg', '17', 65191, 'Wiesbaden', 'Hessen', 'DE'),
('Lutherstraße', '18c', 65183, 'Wiesbaden', 'Hessen', 'DE'),
('Wilhelmstraße', '19', 65197, 'Wiesbaden', 'Hessen', 'DE'),
('Bergstraße', '20', 52066, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Friedrichstraße', '21', 52064, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Hainstraße', '22a', 52068, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Sonnenstraße', '23', 52076, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Goethestraße', '24', 52078, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Kirchweg', '25', 52062, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Heimstraße', '26', 44137, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Klosterstraße', '27b', 44143, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Ringstraße', '28', 44139, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Ahornstraße', '29a', 1219, 'Dresden', 'Sachsen', 'DE'),
('Tannenweg', '30', 1169, 'Dresden', 'Sachsen', 'DE'),
('Eichenallee', '31', 1069, 'Dresden', 'Sachsen', 'DE'),
('Buchenstraße', '32', 1129, 'Dresden', 'Sachsen', 'DE'),
('Kastanienallee', '33', 22083, 'Hamburg', 'Hamburg', 'DE'),
('Maxstraße', '34', 22041, 'Hamburg', 'Hamburg', 'DE'),
('Feldstraße', '35c', 20095, 'Hamburg', 'Hamburg', 'DE'),
('Dorfstraße', '36a', 20359, 'Hamburg', 'Hamburg', 'DE'),
('Lindenstraße', '37', 39120, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Blumenstraße', '38b', 39114, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Schubertstraße', '39', 39110, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Wiesenweg', '40', 39104, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Hauptstraße', '41', 39124, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Brückenstraße', '42', 9111, 'Chemnitz', 'Sachsen', 'DE'),
('Fichtestraße', '43a', 9122, 'Chemnitz', 'Sachsen', 'DE'),
('Zeppelinstraße', '44', 9130, 'Chemnitz', 'Sachsen', 'DE'),
('Elisabethstraße', '45', 45141, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Bahnhofstraße', '46', 45130, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Marktstraße', '47', 45131, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Birkenweg', '48', 45136, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Rosenstraße', '49b', 45127, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Tulpenweg', '50a', 68219, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Mozartstraße', '51', 68167, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Beethovenstraße', '52c', 68169, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Schillerstraße', '53', 68161, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Heinestraße', '54', 24116, 'Kiel', 'Schleswig-Holstein', 'DE'),
('Herderstraße', '55', 24103, 'Kiel', 'Schleswig-Holstein', 'DE'),
('Kantstraße', '56', 48153, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Hegelstraße', '57a', 48145, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Rembrandtstraße', '58', 48165, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Dürerstraße', '59', 48143, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Keplerstraße', '60b', 38110, 'Braunschweig', 'Niedersachsen', 'DE'),
('Kopernikusstraße', '61', 38100, 'Braunschweig', 'Niedersachsen', 'DE'),
('Einsteinstraße', '62', 18106, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Neustraße', '63', 18057, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Alte Straße', '64a', 18146, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Kirchgasse', '65', 18055, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Dammstraße', '66', 70190, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Wiesenstraße', '67', 70173, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Lessingstraße', '68', 70376, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Seestraße', '69c', 70378, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Brunnenweg', '70', 70178, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Schulstraße', '71a', 90402, 'Nürnberg', 'Bayern', 'DE'),
('Uhlandstraße', '72', 90403, 'Nürnberg', 'Bayern', 'DE'),
('Mühlenweg', '73', 90408, 'Nürnberg', 'Bayern', 'DE'),
('Poststraße', '74', 10707, 'Berlin', 'Berlin', 'DE'),
('Waldstraße', '75', 10365, 'Berlin', 'Berlin', 'DE'),
('Gartenstraße', '76', 10243, 'Berlin', 'Berlin', 'DE'),
('Humboldtstraße', '77', 10117, 'Berlin', 'Berlin', 'DE'),
('Fichtenweg', '78a', 10178, 'Berlin', 'Berlin', 'DE'),
('Lutherstraße', '79', 10245, 'Berlin', 'Berlin', 'DE'),
('Wilhelmstraße', '80', 10405, 'Berlin', 'Berlin', 'DE'),
('Bergstraße', '81', 86179, 'Augsburg', 'Bayern', 'DE'),
('Friedrichstraße', '82b', 86153, 'Augsburg', 'Bayern', 'DE'),
('Hainstraße', '83', 86154, 'Augsburg', 'Bayern', 'DE'),
('Sonnenstraße', '84', 86150, 'Augsburg', 'Bayern', 'DE'),
('Goethestraße', '85a', 30163, 'Hannover', 'Niedersachsen', 'DE'),
('Kirchweg', '86c', 30177, 'Hannover', 'Niedersachsen', 'DE'),
('Heimstraße', '87', 30159, 'Hannover', 'Niedersachsen', 'DE'),
('Klosterstraße', '88', 30167, 'Hannover', 'Niedersachsen', 'DE'),
('Ringstraße', '89', 53115, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Ahornstraße', '90', 53113, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Tannenweg', '91', 53227, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Eichenallee', '92a', 53119, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Buchenstraße', '93b', 28201, 'Bremen', 'Bremen', 'DE'),
('Kastanienallee', '94', 28219, 'Bremen', 'Bremen', 'DE'),
('Maxstraße', '95', 28195, 'Bremen', 'Bremen', 'DE'),
('Feldstraße', '96', 28203, 'Bremen', 'Bremen', 'DE'),
('Dorfstraße', '97', 40212, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Lindenstraße', '98', 40211, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Blumenstraße', '99a', 40215, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Schubertstraße', '100', 40221, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Wiesenweg', '101', 76133, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Hauptstraße', '102', 76137, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Brückenstraße', '103c', 76187, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Fichtestraße', '104b', 76149, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Zeppelinstraße', '105', 50667, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Elisabethstraße', '106a', 50823, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Bahnhofstraße', '107', 51063, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Marktstraße', '108', 50733, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Birkenweg', '109', 50668, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Rosenstraße', '110', 60435, 'Frankfurt am Main', 'Hessen', 'DE'),
('Tulpenweg', '111', 60318, 'Frankfurt am Main', 'Hessen', 'DE'),
('Mozartstraße', '112', 60433, 'Frankfurt am Main', 'Hessen', 'DE'),
('Beethovenstraße', '113a', 60325, 'Frankfurt am Main', 'Hessen', 'DE'),
('Schillerstraße', '114', 60327, 'Frankfurt am Main', 'Hessen', 'DE'),
('Heinestraße', '115b', 60322, 'Frankfurt am Main', 'Hessen', 'DE'),
('Herderstraße', '116', 81371, 'München', 'Bayern', 'DE'),
('Kantstraße', '117', 81669, 'München', 'Bayern', 'DE'),
('Hegelstraße', '118', 81541, 'München', 'Bayern', 'DE'),
('Rembrandtstraße', '119', 81377, 'München', 'Bayern', 'DE'),
('Dürerstraße', '1a', 80331, 'München', 'Bayern', 'DE'),
('Keplerstraße', '2', 4177, 'Leipzig', 'Sachsen', 'DE'),
('Kopernikusstraße', '3', 4105, 'Leipzig', 'Sachsen', 'DE'),
('Einsteinstraße', '4', 4107, 'Leipzig', 'Sachsen', 'DE'),
('Neustraße', '5', 4103, 'Leipzig', 'Sachsen', 'DE'),
('Alte Straße', '6', 4275, 'Leipzig', 'Sachsen', 'DE'),
('Kirchgasse', '7b', 99098, 'Erfurt', 'Thüringen', 'DE'),
('Dammstraße', '8a', 99092, 'Erfurt', 'Thüringen', 'DE'),
('Wiesenstraße', '9', 99088, 'Erfurt', 'Thüringen', 'DE'),
('Lessingstraße', '10', 99089, 'Erfurt', 'Thüringen', 'DE'),
('Seestraße', '11', 99084, 'Erfurt', 'Thüringen', 'DE'),
('Brunnenweg', '12', 65191, 'Wiesbaden', 'Hessen', 'DE'),
('Schulstraße', '13', 65183, 'Wiesbaden', 'Hessen', 'DE'),
('Uhlandstraße', '14', 65197, 'Wiesbaden', 'Hessen', 'DE'),
('Mühlenweg', '15a', 52066, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Poststraße', '16', 52064, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Waldstraße', '17', 52068, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Gartenstraße', '18b', 52076, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Humboldtstraße', '19', 52078, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Fichtenweg', '20', 52062, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Lutherstraße', '21', 44137, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Wilhelmstraße', '22a', 44143, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Bergstraße', '23', 44139, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Friedrichstraße', '24', 1219, 'Dresden', 'Sachsen', 'DE'),
('Hainstraße', '25', 1169, 'Dresden', 'Sachsen', 'DE'),
('Sonnenstraße', '26', 1069, 'Dresden', 'Sachsen', 'DE'),
('Goethestraße', '27', 1129, 'Dresden', 'Sachsen', 'DE'),
('Kirchweg', '28', 22083, 'Hamburg', 'Hamburg', 'DE'),
('Heimstraße', '29a', 22041, 'Hamburg', 'Hamburg', 'DE'),
('Klosterstraße', '30', 20095, 'Hamburg', 'Hamburg', 'DE'),
('Ringstraße', '31', 20359, 'Hamburg', 'Hamburg', 'DE'),
('Ahornstraße', '32', 39120, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Tannenweg', '33', 39114, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Eichenallee', '34', 39110, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Buchenstraße', '35c', 39104, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Kastanienallee', '36a', 39124, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Maxstraße', '37', 9111, 'Chemnitz', 'Sachsen', 'DE'),
('Feldstraße', '38', 9122, 'Chemnitz', 'Sachsen', 'DE'),
('Dorfstraße', '39', 9130, 'Chemnitz', 'Sachsen', 'DE'),
('Lindenstraße', '40b', 45141, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Blumenstraße', '41', 45130, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Schubertstraße', '42', 45131, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Wiesenweg', '43a', 45136, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Hauptstraße', '44', 45127, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Brückenstraße', '45', 68219, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Fichtestraße', '46', 68167, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Zeppelinstraße', '47', 68169, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Elisabethstraße', '48', 68161, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Bahnhofstraße', '49', 24116, 'Kiel', 'Schleswig-Holstein', 'DE'),
('Marktstraße', '50a', 24103, 'Kiel', 'Schleswig-Holstein', 'DE'),
('Birkenweg', '51b', 48153, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Rosenstraße', '52c', 48145, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Tulpenweg', '53', 48165, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Mozartstraße', '54', 48143, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Beethovenstraße', '55', 38110, 'Braunschweig', 'Niedersachsen', 'DE'),
('Schillerstraße', '56', 38100, 'Braunschweig', 'Niedersachsen', 'DE'),
('Heinestraße', '57a', 18106, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Herderstraße', '58', 18057, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Kantstraße', '59', 18146, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Hegelstraße', '60', 18055, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Rembrandtstraße', '61', 70190, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Dürerstraße', '62b', 70173, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Keplerstraße', '63', 70376, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Kopernikusstraße', '64a', 70378, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Einsteinstraße', '65', 70178, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Neustraße', '66', 90402, 'Nürnberg', 'Bayern', 'DE'),
('Alte Straße', '67', 90403, 'Nürnberg', 'Bayern', 'DE'),
('Kirchgasse', '68', 90408, 'Nürnberg', 'Bayern', 'DE'),
('Dammstraße', '69c', 10707, 'Berlin', 'Berlin', 'DE'),
('Wiesenstraße', '70', 10365, 'Berlin', 'Berlin', 'DE'),
('Lessingstraße', '71a', 10243, 'Berlin', 'Berlin', 'DE'),
('Seestraße', '72', 10117, 'Berlin', 'Berlin', 'DE'),
('Brunnenweg', '73b', 10178, 'Berlin', 'Berlin', 'DE'),
('Schulstraße', '74', 10245, 'Berlin', 'Berlin', 'DE'),
('Uhlandstraße', '75', 10405, 'Berlin', 'Berlin', 'DE'),
('Mühlenweg', '76', 86179, 'Augsburg', 'Bayern', 'DE'),
('Poststraße', '77', 86153, 'Augsburg', 'Bayern', 'DE'),
('Waldstraße', '78a', 86154, 'Augsburg', 'Bayern', 'DE'),
('Gartenstraße', '79', 86150, 'Augsburg', 'Bayern', 'DE'),
('Humboldtstraße', '80', 30163, 'Hannover', 'Niedersachsen', 'DE'),
('Fichtenweg', '81', 30177, 'Hannover', 'Niedersachsen', 'DE'),
('Lutherstraße', '82', 30159, 'Hannover', 'Niedersachsen', 'DE'),
('Wilhelmstraße', '83', 30167, 'Hannover', 'Niedersachsen', 'DE'),
('Bergstraße', '84b', 53115, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Friedrichstraße', '85a', 53113, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Hainstraße', '86c', 53227, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Sonnenstraße', '87', 53119, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Goethestraße', '88', 28201, 'Bremen', 'Bremen', 'DE'),
('Kirchweg', '89', 28219, 'Bremen', 'Bremen', 'DE'),
('Heimstraße', '90', 28195, 'Bremen', 'Bremen', 'DE'),
('Klosterstraße', '91', 28203, 'Bremen', 'Bremen', 'DE'),
('Ringstraße', '92a', 40212, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Ahornstraße', '93', 40211, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Tannenweg', '94', 40215, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Eichenallee', '95b', 40221, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Buchenstraße', '96', 76133, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Kastanienallee', '97', 76137, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Maxstraße', '98', 76187, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Feldstraße', '99a', 76149, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Dorfstraße', '100', 50667, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Lindenstraße', '101', 50823, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Blumenstraße', '102', 51063, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Schubertstraße', '103c', 50733, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Wiesenweg', '104', 50668, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Hauptstraße', '105', 60435, 'Frankfurt am Main', 'Hessen', 'DE'),
('Brückenstraße', '106a', 60318, 'Frankfurt am Main', 'Hessen', 'DE'),
('Fichtestraße', '107', 60433, 'Frankfurt am Main', 'Hessen', 'DE'),
('Zeppelinstraße', '108', 60325, 'Frankfurt am Main', 'Hessen', 'DE'),
('Elisabethstraße', '109', 60327, 'Frankfurt am Main', 'Hessen', 'DE'),
('Bahnhofstraße', '110', 60322, 'Frankfurt am Main', 'Hessen', 'DE'),
('Marktstraße', '111', 81371, 'München', 'Bayern', 'DE'),
('Birkenweg', '112', 81669, 'München', 'Bayern', 'DE'),
('Rosenstraße', '113a', 81541, 'München', 'Bayern', 'DE'),
('Tulpenweg', '114', 81377, 'München', 'Bayern', 'DE'),
('Mozartstraße', '115', 80331, 'München', 'Bayern', 'DE'),
('Beethovenstraße', '116', 4177, 'Leipzig', 'Sachsen', 'DE'),
('Schillerstraße', '117b', 4105, 'Leipzig', 'Sachsen', 'DE'),
('Heinestraße', '118', 4107, 'Leipzig', 'Sachsen', 'DE'),
('Herderstraße', '119', 4103, 'Leipzig', 'Sachsen', 'DE'),
('Kantstraße', '1a', 4275, 'Leipzig', 'Sachsen', 'DE'),
('Hegelstraße', '2', 99098, 'Erfurt', 'Thüringen', 'DE'),
('Rembrandtstraße', '3', 99092, 'Erfurt', 'Thüringen', 'DE'),
('Dürerstraße', '4', 99088, 'Erfurt', 'Thüringen', 'DE'),
('Keplerstraße', '5', 99089, 'Erfurt', 'Thüringen', 'DE'),
('Kopernikusstraße', '6', 99084, 'Erfurt', 'Thüringen', 'DE'),
('Einsteinstraße', '7', 65191, 'Wiesbaden', 'Hessen', 'DE'),
('Neustraße', '8a', 65183, 'Wiesbaden', 'Hessen', 'DE'),
('Alte Straße', '9b', 65197, 'Wiesbaden', 'Hessen', 'DE'),
('Kirchgasse', '10', 52066, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Dammstraße', '11', 52064, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Wiesenstraße', '12', 52068, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Lessingstraße', '13', 52076, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Seestraße', '14', 52078, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Brunnenweg', '15a', 52062, 'Aachen', 'Nordrhein-Westfalen', 'DE'),
('Schulstraße', '16', 44137, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Uhlandstraße', '17', 44143, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Mühlenweg', '18c', 44139, 'Dortmund', 'Nordrhein-Westfalen', 'DE'),
('Poststraße', '19', 1219, 'Dresden', 'Sachsen', 'DE'),
('Waldstraße', '20b', 1169, 'Dresden', 'Sachsen', 'DE'),
('Gartenstraße', '21', 1069, 'Dresden', 'Sachsen', 'DE'),
('Humboldtstraße', '22a', 1129, 'Dresden', 'Sachsen', 'DE'),
('Fichtenweg', '23', 22083, 'Hamburg', 'Hamburg', 'DE'),
('Lutherstraße', '24', 22041, 'Hamburg', 'Hamburg', 'DE'),
('Wilhelmstraße', '25', 20095, 'Hamburg', 'Hamburg', 'DE'),
('Bergstraße', '26', 20359, 'Hamburg', 'Hamburg', 'DE'),
('Friedrichstraße', '27', 39120, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Hainstraße', '28', 39114, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Sonnenstraße', '29a', 39110, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Goethestraße', '30', 39104, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Kirchweg', '31b', 39124, 'Magdeburg', 'Sachsen-Anhalt', 'DE'),
('Heimstraße', '32', 9111, 'Chemnitz', 'Sachsen', 'DE'),
('Klosterstraße', '33', 9122, 'Chemnitz', 'Sachsen', 'DE'),
('Ringstraße', '34', 9130, 'Chemnitz', 'Sachsen', 'DE'),
('Ahornstraße', '35c', 45141, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Tannenweg', '36a', 45130, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Eichenallee', '37', 45131, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Buchenstraße', '38', 45136, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Kastanienallee', '39', 45127, 'Essen', 'Nordrhein-Westfalen', 'DE'),
('Maxstraße', '40', 68219, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Feldstraße', '41', 68167, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Dorfstraße', '42b', 68169, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Lindenstraße', '43a', 68161, 'Mannheim', 'Baden-Württemberg', 'DE'),
('Blumenstraße', '44', 24116, 'Kiel', 'Schleswig-Holstein', 'DE'),
('Schubertstraße', '45', 24103, 'Kiel', 'Schleswig-Holstein', 'DE'),
('Wiesenweg', '46', 48153, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Hauptstraße', '47', 48145, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Brückenstraße', '48', 48165, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Fichtestraße', '49', 48143, 'Münster', 'Nordrhein-Westfalen', 'DE'),
('Zeppelinstraße', '50a', 38110, 'Braunschweig', 'Niedersachsen', 'DE'),
('Elisabethstraße', '51', 38100, 'Braunschweig', 'Niedersachsen', 'DE'),
('Bahnhofstraße', '52c', 18106, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Marktstraße', '53b', 18057, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Birkenweg', '54', 18146, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Rosenstraße', '55', 18055, 'Rostock', 'Mecklenburg-Vorpommern', 'DE'),
('Tulpenweg', '56', 70190, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Mozartstraße', '57a', 70173, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Beethovenstraße', '58', 70376, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Schillerstraße', '59', 70378, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Heinestraße', '60', 70178, 'Stuttgart', 'Baden-Württemberg', 'DE'),
('Herderstraße', '61', 90402, 'Nürnberg', 'Bayern', 'DE'),
('Kantstraße', '62', 90403, 'Nürnberg', 'Bayern', 'DE'),
('Hegelstraße', '63', 90408, 'Nürnberg', 'Bayern', 'DE'),
('Rembrandtstraße', '64a', 10707, 'Berlin', 'Berlin', 'DE'),
('Dürerstraße', '65', 10365, 'Berlin', 'Berlin', 'DE'),
('Keplerstraße', '66', 10243, 'Berlin', 'Berlin', 'DE'),
('Kopernikusstraße', '67', 10117, 'Berlin', 'Berlin', 'DE'),
('Einsteinstraße', '68', 10178, 'Berlin', 'Berlin', 'DE'),
('Neustraße', '69c', 10245, 'Berlin', 'Berlin', 'DE'),
('Alte Straße', '70', 10405, 'Berlin', 'Berlin', 'DE'),
('Kirchgasse', '71a', 86179, 'Augsburg', 'Bayern', 'DE'),
('Dammstraße', '72', 86153, 'Augsburg', 'Bayern', 'DE'),
('Wiesenstraße', '73', 86154, 'Augsburg', 'Bayern', 'DE'),
('Lessingstraße', '74', 86150, 'Augsburg', 'Bayern', 'DE'),
('Seestraße', '75b', 30163, 'Hannover', 'Niedersachsen', 'DE'),
('Brunnenweg', '76', 30177, 'Hannover', 'Niedersachsen', 'DE'),
('Schulstraße', '77', 30159, 'Hannover', 'Niedersachsen', 'DE'),
('Uhlandstraße', '78a', 30167, 'Hannover', 'Niedersachsen', 'DE'),
('Mühlenweg', '79', 53115, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Poststraße', '80', 53113, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Waldstraße', '81', 53227, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Gartenstraße', '82', 53119, 'Bonn', 'Nordrhein-Westfalen', 'DE'),
('Humboldtstraße', '83', 28201, 'Bremen', 'Bremen', 'DE'),
('Fichtenweg', '84', 28219, 'Bremen', 'Bremen', 'DE'),
('Lutherstraße', '85a', 28195, 'Bremen', 'Bremen', 'DE'),
('Wilhelmstraße', '86b', 28203, 'Bremen', 'Bremen', 'DE'),
('Bergstraße', '87', 40212, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Friedrichstraße', '88', 40211, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Hainstraße', '89', 40215, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Sonnenstraße', '90', 40221, 'Düsseldorf', 'Nordrhein-Westfalen', 'DE'),
('Goethestraße', '91', 76133, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Kirchweg', '92a', 76137, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Heimstraße', '93', 76187, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Klosterstraße', '94', 76149, 'Karlsruhe', 'Baden-Württemberg', 'DE'),
('Ringstraße', '95', 50667, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Ahornstraße', '96', 50823, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Tannenweg', '97b', 51063, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Eichenallee', '98', 50733, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Buchenstraße', '99a', 50668, 'Köln', 'Nordrhein-Westfalen', 'DE'),
('Kastanienallee', '100', 60435, 'Frankfurt am Main', 'Hessen', 'DE'),
('Maxstraße', '101', 60318, 'Frankfurt am Main', 'Hessen', 'DE'),
('Feldstraße', '102', 60433, 'Frankfurt am Main', 'Hessen', 'DE'),
('Dorfstraße', '103c', 60325, 'Frankfurt am Main', 'Hessen', 'DE'),
('Lindenstraße', '104', 60327, 'Frankfurt am Main', 'Hessen', 'DE'),
('Blumenstraße', '105', 60322, 'Frankfurt am Main', 'Hessen', 'DE'),
('Schubertstraße', '106a', 81371, 'München', 'Bayern', 'DE'),
('Wiesenweg', '107', 81669, 'München', 'Bayern', 'DE'),
('Hauptstraße', '108b', 81541, 'München', 'Bayern', 'DE'),
('Brückenstraße', '109', 81377, 'München', 'Bayern', 'DE'),
('Fichtestraße', '110', 80331, 'München', 'Bayern', 'DE'),
('Zeppelinstraße', '111', 4177, 'Leipzig', 'Sachsen', 'DE'),
('Elisabethstraße', '112', 4105, 'Leipzig', 'Sachsen', 'DE'),
('Bahnhofstraße', '113a', 4107, 'Leipzig', 'Sachsen', 'DE'),
('Marktstraße', '114', 4103, 'Leipzig', 'Sachsen', 'DE'),
('Birkenweg', '115', 4275, 'Leipzig', 'Sachsen', 'DE'),
('Rosenstraße', '116', 99098, 'Erfurt', 'Thüringen', 'DE'),
('Tulpenweg', '117', 99092, 'Erfurt', 'Thüringen', 'DE'),
('Mozartstraße', '118', 99088, 'Erfurt', 'Thüringen', 'DE'),
('Beethovenstraße', '119b', 99089, 'Erfurt', 'Thüringen', 'DE'),
('Schillerstraße', '1a', 99084, 'Erfurt', 'Thüringen', 'DE'),
('Heinestraße', '2', 65191, 'Wiesbaden', 'Hessen', 'DE'),
('Herderstraße', '3', 65183, 'Wiesbaden', 'Hessen', 'DE'),
('Kantstraße', '4', 65197, 'Wiesbaden', 'Hessen', 'DE'),
('Hegelstraße', '5', 52066, 'Aachen', 'Nordrhein-Westfalen', 'DE');

-- 600 Mitarbeiter
-- Standort_id wird hier bewusst NICHT gesetzt (bleibt NULL).
-- Die Zuweisung erfolgt weiter unten, nachdem die Arbeitsverhältnisse
-- angelegt wurden, damit jeder Mitarbeiter einen Standort einer Firma
-- erhält, mit der er tatsächlich ein Arbeitsverhältnis hat.
DO $$
DECLARE
  vornamen        TEXT[] := ARRAY[
    'Peter','Thomas','Michael','Stefan','Andreas','Markus','Christian','Daniel',
    'Tobias','Sebastian','Matthias','Patrick','Alexander','Florian','Martin',
    'Oliver','Lukas','Simon','Tim','Philipp','Maximilian','Leon','Niklas',
    'Sven','Rainer','Georg','Walter','Josef','Karl','Erik',
    'Lisa','Sarah','Julia','Sandra','Nicole','Stefanie','Christine','Susanne',
    'Monika','Birgit','Petra','Claudia','Sabine','Andrea','Karin','Heike',
    'Laura','Lea','Lena','Hannah','Emma','Sophie','Jana','Tina',
    'Nadine','Melanie','Sonja','Dagmar','Ursula','Ilse','Werner','Franz',
    'Holger','Bernd','Dieter','Horst','Uwe','Frank','Klaus',
    'Renate','Ingrid','Brigitte','Ute','Gerda','Martha',
    'Rolf','Manfred','Gerhard','Siegfried','Herbert','Rudolf','Helmut','Kurt',
    'Hannelore','Angelika','Kerstin','Verena','Annette','Cornelia','Dorothea','Elke',
    'Burkhard','Norbert','Volker','Carsten','Dennis','Fabian','Jan','Marco',
    'Susanna','Bianca','Yvonne','Anke','Bettina','Sabrina','Tanja','Katharina'
  ];
  nachnamen       TEXT[] := ARRAY[
    'Müller','Schmidt','Weber','Schäfer','Klein','Schröder','Neumann','Schwarz',
    'Zimmermann','Krüger','Hofmann','Hartmann','Schmitt','Werner','Meier','Lehmann',
    'Schmid','Schulze','Maier','Köhler','Herrmann','König','Huber','Kaiser',
    'Fuchs','Lang','Scholz','Möller','Weiß','Jung','Hahn','Schubert',
    'Vogel','Friedrich','Berg','Roth','Winkler','Haas','Schreiber','Ziegler',
    'Brandt','Franke','Albrecht','Winter','Schumacher','Ludwig','Böhm','Sommer',
    'Hansen','Ernst','Günther','Seidel','Lenz','Keller','Engel','Busch',
    'Lorenz','Simon','Berger','Vogt','Kuhn','Thomas','Mann','Jäger',
    'Beck','Groß','Ritter','Otto','Sauer','Henning','Pfeiffer','Kolb',
    'Baumann','Langer','Arnold','Pieper','Adam','Brauer','Rohde','Kluge',
    'Hamann','Voigt','Geiger','Köster','Wenzel','Stein','Graf','Frey',
    'Lindner','Metz','Krohn','Wulf','Seiler','Theis','Kraft','Nagel',
    'Bender','Hesse','Stahl','Riedel'
  ];
  email_nachname  TEXT[] := ARRAY[
    'mueller','schmidt','weber','schaefer','klein','schroeder','neumann','schwarz',
    'zimmermann','krueger','hofmann','hartmann','schmitt','werner','meier','lehmann',
    'schmid','schulze','maier','koehler','herrmann','koenig','huber','kaiser',
    'fuchs','lang','scholz','moeller','weiss','jung','hahn','schubert',
    'vogel','friedrich','berg','roth','winkler','haas','schreiber','ziegler',
    'brandt','franke','albrecht','winter','schumacher','ludwig','boehm','sommer',
    'hansen','ernst','guenther','seidel','lenz','keller','engel','busch',
    'lorenz','simon','berger','vogt','kuhn','thomas','mann','jaeger',
    'beck','gross','ritter','otto','sauer','henning','pfeiffer','kolb',
    'baumann','langer','arnold','pieper','adam','brauer','rohde','kluge',
    'hamann','voigt','geiger','koester','wenzel','stein','graf','frey',
    'lindner','metz','krohn','wulf','seiler','theis','kraft','nagel',
    'bender','hesse','stahl','riedel'
  ];
  i      INT;
  pnr    INT;
  vi     INT;
  li     INT;
  fname  TEXT;
  ldisp  TEXT;
  lemail TEXT;
BEGIN
  FOR i IN 0..599 LOOP
    pnr    := 10000001 + i;
    vi     := (i % array_length(vornamen, 1))       + 1;
    li     := (i % array_length(nachnamen, 1))      + 1;
    fname  := lower(vornamen[vi]);
    ldisp  := nachnamen[li];
    lemail := email_nachname[li];

    INSERT INTO Mitarbeiter (
      Personalnummer, Name, A_Kennung, Geburtsdatum, Privatadresse_id,
      Email_geschaeftlich, Email_privat,
      Mobilnummer_geschaeftlich, Mobilnummer_privat
    ) VALUES (
      pnr,
      vornamen[vi] || ' ' || ldisp,
      'a' || (10016 + i)::TEXT,
      make_date(1970 + (i % 28), (i % 12) + 1, (i % 28) + 1),
      37 + i,
      fname || '.' || lemail || '@telekom.de',
      fname || '.' || lemail || '@gmail.com',
      '+49151' || pnr::TEXT,
      '+49152' || pnr::TEXT
    );
  END LOOP;
END;
$$;

INSERT INTO Buerogebaeude (
    Adresse_id,
    Verantwortlicher,
    Firma,
    Kantine_vorhanden
)
VALUES
( 1, 10000001, 'Deutsche Telekom AG', true),
( 2, 10000002, 'Telekom Deutschland GmbH', false),
( 3, 10000003, 'T-Systems International GmbH', true),
( 4, 10000004, 'congstar GmbH', false),
( 5, 10000005, 'Deutsche Telekom MMS GmbH', true), 
( 6, 10000006, 'Deutsche Telekom Privatkunden-Vertrieb GmbH', false),
( 7, 10000007, 'Deutsche Telekom AG', true), 
( 8, 10000008, 'Telekom Deutschland GmbH', false),
( 9, 10000009, 'congstar GmbH', false),
( 10, 10000010, 'Deutsche Telekom MMS GmbH', true); 

INSERT INTO Telekom_Shop (
    Adresse_id,
    Verantwortlicher,
    Firma,
    Oeffnungszeit,
    Schliesszeit,
    Bestand_Router,
    Bestand_Handys,
    Bestand_SIM_Karten
)
VALUES
(11, 10000011, 'Deutsche Telekom Privatkunden-Vertrieb GmbH', '09:00', '20:00', 18,  85, 220),
(12, 10000012, 'Deutsche Telekom Privatkunden-Vertrieb GmbH', '09:00', '19:30', 14,  70, 190),
(13, 10000013, 'Deutsche Telekom Privatkunden-Vertrieb GmbH', '10:00', '19:00', 10,  55, 150),
(14, 10000014, 'Deutsche Telekom Privatkunden-Vertrieb GmbH', '09:30', '20:00', 12,  60, 175),
(15, 10000015, 'Deutsche Telekom Privatkunden-Vertrieb GmbH', '10:00', '20:00', 20, 100, 260);

CREATE OR REPLACE FUNCTION check_standort_id_exists()
RETURNS trigger
SET search_path = unternehmensstruktur, public
AS $$
BEGIN
    IF NEW.Standort_id IS NOT NULL THEN
        IF NOT EXISTS (
            SELECT 1
            FROM   Standort          -- ohne ONLY → inkl. aller Kindtabellen
            WHERE  Standort_id = NEW.Standort_id
        ) THEN
            RAISE EXCEPTION
                'Standort_id % existiert in keiner Standort-Tabelle (Standort, Telekom_Shop, Buerogebaeude)',
                NEW.Standort_id;
        END IF;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Mitarbeiter
ALTER TABLE Mitarbeiter
DROP CONSTRAINT mitarbeiter_standort_id_fkey;

CREATE TRIGGER trg_mitarbeiter_standort_id_fkey
BEFORE INSERT OR UPDATE ON Mitarbeiter
FOR EACH ROW EXECUTE FUNCTION check_standort_id_exists();

-- Firma
ALTER TABLE Firma
DROP CONSTRAINT firma_standort_id_fkey;

CREATE TRIGGER trg_firma_standort_id_fkey
BEFORE INSERT OR UPDATE ON Firma
FOR EACH ROW EXECUTE FUNCTION check_standort_id_exists();

-- Organisationseinheit
ALTER TABLE Organisationseinheit
DROP CONSTRAINT organisationseinheit_standort_id_fkey;

CREATE TRIGGER trg_organisationseinheit_standort_id_fkey
BEFORE INSERT OR UPDATE ON Organisationseinheit
FOR EACH ROW EXECUTE FUNCTION check_standort_id_exists();

UPDATE Mitarbeiter m
SET    Standort_id = s.Standort_id
FROM   Standort s
WHERE  s.Verantwortlicher = m.Personalnummer;

-- Firmen
INSERT INTO Firma
values
('Deutsche Telekom AG',1),
('Telekom Deutschland GmbH', 2),
('T-Systems International GmbH', 3),
('congstar GmbH', 4),
('Deutsche Telekom MMS GmbH', 5),
('Deutsche Telekom Privatkunden-Vertrieb GmbH', 6);

-- Meetingräume: 3 pro Bürogebäude
INSERT INTO Meetingraum (Bezeichnung, Standort_id, LAN_vorhanden, WLAN_vorhanden, Kapazitaet, Webex_Board_vorhanden)
SELECT
  'A.' || LPAD(n::text, 2, '0'),
  b.Standort_id,
  false,
  true,
  CASE n WHEN 3 THEN 6 WHEN 6 THEN 10 WHEN 9 THEN 20 END,
  CASE n WHEN 2 THEN true ELSE false END
FROM Buerogebaeude b
CROSS JOIN generate_series(1, 10) AS n;

-- Schreibtische: 10 pro Bürogebäude (7 höhenverstellbar, 3 nicht)
INSERT INTO Schreibtisch (Bezeichnung, Standort_id, LAN_vorhanden, WLAN_vorhanden, hoehenverstellbar, Anzahl_Monitore)
SELECT
  'B.01-' || LPAD(n::text, 2, '0'),
  b.Standort_id,
  true,
  true,
  n <= 70,
  CASE WHEN n <= 70 THEN 20 ELSE 1 END
FROM Buerogebaeude b
CROSS JOIN generate_series(1, 100) AS n;

-- Arbeitsplatzbuchungen
DO $$
DECLARE
    -- Mo–Fr, erste KW März 2026
    tage DATE[] := ARRAY[
        '2026-03-02'::date,   -- Montag
        '2026-03-03'::date,   -- Dienstag
        '2026-03-04'::date,   -- Mittwoch
        '2026-03-05'::date,   -- Donnerstag
        '2026-03-06'::date    -- Freitag
    ];

    -- Alle gültigen Arbeitsplatz-Bezeichnungen je Bürogebäude
    -- 3 Meetingräume (A.01–A.03) + 10 Schreibtische (B.01-01–B.01-10)
    bezeichnungen TEXT[] := ARRAY[
        'A.01', 'A.02', 'A.03',
        'B.01-01', 'B.01-02', 'B.01-03', 'B.01-04', 'B.01-05',
        'B.01-06', 'B.01-07', 'B.01-08', 'B.01-09', 'B.01-10'
    ];

    tag      DATE;
    ziel     INT;
    cnt      INT;
    ma_pnr   INT;
    s_id     INT;
    bez      TEXT;
    rows_ins INT;
BEGIN
    FOREACH tag IN ARRAY tage LOOP
        -- Zufällige Buchungsanzahl zwischen 20 und 50
        ziel := 20 + floor(random() * 31)::int;
        cnt  := 0;

        WHILE cnt < ziel LOOP
            -- 1. Gleichmäßige Verteilung: zufälligen Bürogebäude-Standort wählen (6–15)
            s_id := 1 + floor(random() * 10)::int;

            -- 2. Zufälligen Mitarbeiter genau dieses Standorts wählen
            --    → erfüllt die Regel "nur am eigenen Standort buchen"
            SELECT Personalnummer
            INTO   ma_pnr
            FROM   Mitarbeiter
            WHERE  Standort_id = s_id
            ORDER BY random()
            LIMIT 1;

            -- 3. Zufällige Arbeitsplatz-Bezeichnung
            bez := bezeichnungen[
                1 + floor(random() * array_length(bezeichnungen, 1))::int
            ];

            -- 4. Buchung einfügen; PK-Konflikte (selbe Kombi bereits gebucht) ignorieren
            INSERT INTO Buchung (Mitarbeiter, Bezeichnung, Standort_id, Datum)
            VALUES (ma_pnr, bez, s_id, tag)
            ON CONFLICT DO NOTHING;

            GET DIAGNOSTICS rows_ins = ROW_COUNT;
            cnt := cnt + rows_ins;
        END LOOP;
    END LOOP;
END;
$$;

-- ============================================================
-- Organisationseinheiten
-- ============================================================

-- Pro Firma: 2 Tribes
-- Pro Tribe: 2 Supersquads und 2 Superchapters
-- Pro Supersquad: 3 Squads
-- Pro Superchapter: 2 Chapters

DO $$
DECLARE
    firmen TEXT[] := ARRAY[
        'Deutsche Telekom AG',
        'Telekom Deutschland GmbH',
        'T-Systems International GmbH',
        'congstar GmbH',
        'Deutsche Telekom MMS GmbH',
        'Deutsche Telekom Privatkunden-Vertrieb GmbH'
    ];

    firma_name TEXT;
    tribe_counter INT;
    supersquad_counter INT;
    superchapter_counter INT;
    squad_counter INT;
    chapter_counter INT;
    
    -- IDs für erstellte Organisationseinheiten
    tribe_id INT;
    supersquad_id INT;
    superchapter_id INT;
    
    -- Für Leiter und Standort
    leiter_pnr INT;
    standort_id_val INT;
    
    -- Hilfsvariable für bereits vergebene Leiter
    used_leaders INT[] := ARRAY[]::INT[];
BEGIN
    -- Für jede Firma
    FOR i IN 1..6 LOOP
        firma_name := firmen[i];
        
        -- 2 Tribes pro Firma
        FOR tribe_counter IN 1..2 LOOP
            -- Leiter für Tribe finden (wurde noch nicht vergeben)
            SELECT m.Personalnummer
            INTO leiter_pnr
            FROM Mitarbeiter m
            WHERE m.Personalnummer NOT IN (SELECT unnest(used_leaders))
            LIMIT 1;

			-- Standort für OE wählen (muss der Firma der OE gehören)
			select s.Standort_id
			into standort_id_val
			from Buerogebaeude s
			where s.Firma = firmen[i]
			order by random()
			limit 1;
            
            used_leaders := array_append(used_leaders, leiter_pnr);
            
            -- Tribe erstellen
            INSERT INTO Organisationseinheit (Name, Art, Standort_id, Leiter, Firma)
            VALUES ('Tribe-' || i || '-' || tribe_counter, 'Tribe', standort_id_val, leiter_pnr, firma_name)
            RETURNING Einheitsnummer INTO tribe_id;
            
            -- 2 Supersquads pro Tribe
            FOR supersquad_counter IN 1..2 LOOP
                -- Leiter für Supersquad finden
                SELECT m.Personalnummer
	            INTO leiter_pnr
    	        FROM Mitarbeiter m
        	    WHERE m.Personalnummer NOT IN (SELECT unnest(used_leaders))
            	LIMIT 1;

				-- Standort für OE wählen (muss der Firma der OE gehören)
				select s.Standort_id
				into standort_id_val
				from Buerogebaeude s
				where s.Firma = firmen[i]
				order by random()
				limit 1;
                
                used_leaders := array_append(used_leaders, leiter_pnr);
                
                -- Supersquad erstellen
                INSERT INTO Organisationseinheit (Name, Art, Standort_id, Leiter, Firma, uebergeordnete_OE)
                VALUES ('Supersquad-' || i || '-' || tribe_counter || '-' || supersquad_counter, 'Supersquad', standort_id_val, leiter_pnr, firma_name, tribe_id)
                RETURNING Einheitsnummer INTO supersquad_id;
                
                -- 3 Squads pro Supersquad
                FOR squad_counter IN 1..3 LOOP
                    -- Leiter für Squad finden
                    SELECT m.Personalnummer
		            INTO leiter_pnr
		            FROM Mitarbeiter m
		            WHERE m.Personalnummer NOT IN (SELECT unnest(used_leaders))
		            LIMIT 1;

					-- Standort für OE wählen (muss der Firma der OE gehören)
					select s.Standort_id
					into standort_id_val
					from Standort s
					where s.Firma = firmen[i]
					order by random()
					limit 1;
                    
                    used_leaders := array_append(used_leaders, leiter_pnr);
                    
                    -- Squad erstellen
                    INSERT INTO Organisationseinheit (Name, Art, Standort_id, Leiter, Firma, uebergeordnete_OE)
                    VALUES ('Squad-' || i || '-' || tribe_counter || '-' || supersquad_counter || '-' || squad_counter, 'Squad', standort_id_val, leiter_pnr, firma_name, supersquad_id);
                END LOOP;
            END LOOP;
            
            -- 2 Superchapters pro Tribe
            FOR superchapter_counter IN 1..2 LOOP
                -- Leiter für Superchapter finden
                SELECT m.Personalnummer
	            INTO leiter_pnr
	            FROM Mitarbeiter m
	            WHERE m.Personalnummer NOT IN (SELECT unnest(used_leaders))
	            LIMIT 1;

				-- Standort für OE wählen (muss der Firma der OE gehören)
				select s.Standort_id
				into standort_id_val
				from Buerogebaeude s
				where s.Firma = firmen[i]
				order by random()
				limit 1;
                
                used_leaders := array_append(used_leaders, leiter_pnr);
                
                -- Superchapter erstellen
                INSERT INTO Organisationseinheit (Name, Art, Standort_id, Leiter, Firma, uebergeordnete_OE)
                VALUES ('Superchapter-' || i || '-' || tribe_counter || '-' || superchapter_counter, 'Superchapter', standort_id_val, leiter_pnr, firma_name, tribe_id)
                RETURNING Einheitsnummer INTO superchapter_id;
                
                -- 2 Chapters pro Superchapter
                FOR chapter_counter IN 1..2 LOOP
                    -- Leiter für Chapter finden
                    SELECT m.Personalnummer
		            INTO leiter_pnr
		            FROM Mitarbeiter m
		            WHERE m.Personalnummer NOT IN (SELECT unnest(used_leaders))
		            LIMIT 1;
		
					-- Standort für OE wählen (muss der Firma der OE gehören)
					select s.Standort_id
					into standort_id_val
					from Buerogebaeude s
					where s.Firma = firmen[i]
					order by random()
					limit 1;
                    
                    used_leaders := array_append(used_leaders, leiter_pnr);
                    
                    -- Chapter erstellen
                    INSERT INTO Organisationseinheit (Name, Art, Standort_id, Leiter, Firma, uebergeordnete_OE)
                    VALUES ('Chapter-' || i || '-' || tribe_counter || '-' || superchapter_counter || '-' || chapter_counter, 'Chapter', standort_id_val, leiter_pnr, firma_name, superchapter_id);
                END LOOP;
            END LOOP;
        END LOOP;
    END LOOP;
END;
$$;

INSERT INTO Mitglied
SELECT
    Leiter         AS Mitarbeiter,
    Einheitsnummer AS Organisationseinheit
FROM Organisationseinheit
ON CONFLICT DO NOTHING;

UPDATE Mitarbeiter m
SET    Standort_id = (
    SELECT Standort_id
    FROM   Standort s
    ORDER BY random() + (m.Personalnummer * 0)  -- forces per-row evaluation
    LIMIT  1
)
WHERE m.Personalnummer >= 10000016;

-- Mitglieder (Nicht-Leiter)
-- Jeder Mitarbeiter ohne OE-Leitung bekommt einen zufälligen Squad
-- und ein zufälliges Chapter desselben Tribes

-- Schritt 1: Zufälligen Squad + zugehörigen Tribe pro Mitarbeiter ermitteln
CREATE TEMP TABLE _squad_tmp AS
SELECT
    nl.Personalnummer,
    rand_sq.squad_id,
    rand_sq.tribe_id
FROM (
    SELECT m.Personalnummer
    FROM   Mitarbeiter m
    WHERE  m.Personalnummer NOT IN (
               SELECT oe.Leiter
               FROM   Organisationseinheit oe
               WHERE  oe.Leiter IS NOT NULL
           )
) nl
CROSS JOIN LATERAL (
    SELECT
        s.Einheitsnummer     AS squad_id,
        tribe.Einheitsnummer AS tribe_id
    FROM   Organisationseinheit s
    JOIN   Organisationseinheit ss    ON ss.Einheitsnummer    = s.uebergeordnete_OE
    JOIN   Organisationseinheit tribe ON tribe.Einheitsnummer = ss.uebergeordnete_OE
    WHERE  s.Art     = 'Squad'
      AND  ss.Art    = 'Supersquad'
      AND  tribe.Art = 'Tribe'
    ORDER BY random() + (nl.Personalnummer * 0)  -- erzwingt per-Zeile-Auswertung
    LIMIT 1
) rand_sq;

-- Schritt 2: Squad-Mitgliedschaften einfügen
INSERT INTO Mitglied (Mitarbeiter, Organisationseinheit)
SELECT Personalnummer, squad_id
FROM   _squad_tmp
ON CONFLICT DO NOTHING;

-- Schritt 3: Chapter-Mitgliedschaft aus demselben Tribe einfügen
INSERT INTO Mitglied (Mitarbeiter, Organisationseinheit)
SELECT
    t.Personalnummer,
    rand_ch.chapter_id
FROM _squad_tmp t
CROSS JOIN LATERAL (
    SELECT c.Einheitsnummer AS chapter_id
    FROM   Organisationseinheit c
    JOIN   Organisationseinheit sc ON sc.Einheitsnummer = c.uebergeordnete_OE
    WHERE  c.Art  = 'Chapter'
      AND  sc.Art = 'Superchapter'
      AND  sc.uebergeordnete_OE = t.tribe_id
    ORDER BY random() + (t.Personalnummer * 0)  -- erzwingt per-Zeile-Auswertung
    LIMIT 1
) rand_ch
ON CONFLICT DO NOTHING;

-- Aufräumen
DROP TABLE _squad_tmp;

-- Kunden
INSERT INTO Kunde (Firmenname, Adresse_id, Mobilnummer, Email)
VALUES
  ('Alpentech GmbH',                1,  '+4928150001', 'info@alpentech.de'),
  ('NordData AG',                   2,  '+4940390002', 'kontakt@norddata.de'),
  ('Rhein Solutions GmbH',          3,  '+4922180003', 'office@rheinsolutions.de'),
  ('Sachsen Digital KG',            4,  '+4934180004', 'anfragen@sachsen-digital.de'),
  ('Hanseatische IT GmbH',          5,  '+4940690005', 'service@hanseatische-it.de'),
  ('Bayernsoft AG',                 6,  '+4989770006', 'hallo@bayernsoft.de'),
  ('Westfalen Networks GmbH',       7,  '+4923190007', 'info@westfalen-networks.de'),
  ('Elbe Consulting GmbH',          8,  '+4940500008', 'beratung@elbe-consulting.de'),
  ('Schwarzwald Systeme GmbH',      9,  '+4976170009', 'kontakt@schwarzwald-systeme.de'),
  ('Spreemetropol IT GmbH',        10,  '+4930120010', 'office@spreemetropol.de');

INSERT INTO Projekt (
    ICTO_Nummer, Name, Status, Risikostufe, Budget,
    Organisationseinheit, Kunde,
    Deadline, Fortschritt
)
SELECT
    t.icto,
    t.pname,
    t.pstatus,
    t.risiko,
    t.budget,
    oe.Einheitsnummer,
    t.kunde,
    t.deadline::date,
    t.fortschritt
FROM (VALUES
    -- Modernisierung des Legacy-Abrechnungssystems
    ('ICTO-1001', 'Phoenix Rising',       'In Progress',    4, 30000000, 'Squad-1-1-1-1',  1, '2026-12-31',  45),
    -- BI-Plattform für Echtzeit-Netzwerkanalysen
    ('ICTO-1002', 'NordStar Analytics',   'Abgeschlossen',  2,  4500000, 'Squad-2-1-1-1',  2, '2025-06-30', 100),
    -- Zero-Trust-Netzwerksicherheitsarchitektur
    ('ICTO-1003', 'Aegis Shield',         'In Progress',    3, 15000000, 'Squad-3-1-1-1',  3, '2027-03-31',  30),
    -- KI-gestütztes autonomes Netzwerk-Management
    ('ICTO-1004', 'Quantum Leap',         'Nicht gestartet',5, 50000000, 'Squad-4-1-1-1',  4, '2028-06-30',   0),
    -- Cloud-Migration der On-Premise-Kernsysteme
    ('ICTO-1005', 'SilverStream',         'In Progress',    3, 20000000, 'Squad-5-1-1-1',  5, '2026-09-30',  60),
    -- IoT-Integrationsplattform für Smart-City-Infrastruktur
    ('ICTO-1006', 'EchoGrid',             'Abgebrochen',    4,  7500000, 'Squad-1-1-2-1',  6, '2025-12-31',  25),
    -- 5G-Rollout-Steuerung für 12.000 Standorte
    ('ICTO-1007', 'Cobalt Connect',       'Nicht gestartet',5, 80000000, 'Squad-2-1-2-1',  7, '2029-12-31',   0),
    -- Next-Gen Kundenselbstbedienungsportal
    ('ICTO-1008', 'Helix Portal',         'Abgeschlossen',  2,  2500000, 'Squad-3-1-2-1',  8, '2025-03-31', 100),
    -- ML-basierte Echtzeit-Betrugserkennung
    ('ICTO-1009', 'DawnBreaker',          'In Progress',    3,  6500000, 'Squad-4-1-2-1',  9, '2026-06-30',  55),
    -- Geo-redundantes Rechenzentrum-Failover-System
    ('ICTO-1010', 'Ironclad Backbone',    'In Progress',    4, 25000000, 'Squad-5-1-2-1', 10, '2027-06-30',  35)
) AS t(icto, pname, pstatus, risiko, budget, oe_name, kunde, deadline, fortschritt)
JOIN Organisationseinheit oe ON oe.Name = t.oe_name;


-- ----------------------------------------------------------------
-- 10 Systeme
-- ----------------------------------------------------------------
INSERT INTO System (
    ICTO_Nummer, Name, Status, Risikostufe, Budget,
    Organisationseinheit, Kunde,
    End_Of_Life_Datum
)
SELECT
    t.icto,
    t.sname,
    t.sstatus,
    t.risiko,
    t.budget,
    oe.Einheitsnummer,
    t.kunde,
    t.eol::date
FROM (VALUES
    -- Zentrales Kundenstammdatensystem (MDM)
    ('ICTO-2001', 'Meridian Core',     'In Progress',     3,  5000000, 'Squad-1-2-1-1',  1, '2030-12-31'),
    -- Zentralisiertes Logging- und Monitoring-System
    ('ICTO-2002', 'Polaris Log',       'Abgeschlossen',   1,   800000, 'Squad-2-2-1-1',  2, '2028-06-30'),
    -- API-Gateway und Enterprise-Service-Bus
    ('ICTO-2003', 'Titan Gateway',     'In Progress',     3,  3500000, 'Squad-3-2-1-1',  3, '2029-12-31'),
    -- DSGVO-konformes verschlüsseltes Dokumentenarchiv
    ('ICTO-2004', 'ClearVault',        'Nicht gestartet', 2,  1200000, 'Squad-4-2-1-1',  4, '2031-12-31'),
    -- KI-erweitertes Customer-Relationship-Management
    ('ICTO-2005', 'NebulaCRM',         'In Progress',     4, 12000000, 'Squad-5-2-1-1',  5, '2030-06-30'),
    -- Identity- und Access-Management-Plattform (IAM)
    ('ICTO-2006', 'ArctosID',          'Abgeschlossen',   3,  4000000, 'Squad-1-2-2-1',  6, '2027-12-31'),
    -- Dynamisches Traffic-Management für BGP/MPLS-Netze
    ('ICTO-2007', 'SwiftRoute',        'In Progress',     3,  9000000, 'Squad-2-2-2-1',  7, '2032-06-30'),
    -- Hochperformante Zeitreihendatenbank für Netzwerkmetriken
    ('ICTO-2008', 'ChromaDB',          'Abgebrochen',     2,   600000, 'Squad-3-2-2-1',  8, '2026-12-31'),
    -- KI-gestütztes Netzwerk-Anomalieerkennungssystem
    ('ICTO-2009', 'StormWatch',        'In Progress',     4, 18000000, 'Squad-4-2-2-1',  9, '2031-06-30'),
    -- Kaltdaten-Langzeitarchivierung mit Deduplizierung
    ('ICTO-2010', 'GlacierStore',      'Nicht gestartet', 2,  2200000, 'Squad-5-2-2-1', 10, '2033-12-31')
) AS t(icto, sname, sstatus, risiko, budget, oe_name, kunde, eol)
JOIN Organisationseinheit oe ON oe.Name = t.oe_name;

ALTER TABLE Abhaengigkeit DISABLE TRIGGER ALL;

INSERT INTO Abhaengigkeit (Upstream_IT_Asset, Downstream_IT_Asset) values

-- ── Meridian Core (ICTO-2001) – Kundenstammdatensystem (MDM) ──────────────
-- Viele Assets hängen von zentralen Kundendaten ab
('ICTO-2001', 'ICTO-1001'),  -- Phoenix Rising: Abrechnungssystem braucht MDM
('ICTO-2001', 'ICTO-1008'),  -- Helix Portal: Kundenportal braucht MDM
('ICTO-2001', 'ICTO-1009'),  -- DawnBreaker: Betrugserkennung braucht Kundendaten
('ICTO-2001', 'ICTO-2005'),  -- NebulaCRM: CRM-System baut auf MDM auf

-- ── ArctosID (ICTO-2006) – IAM-Plattform ─────────────────────────────────
-- Authentifizierung und Autorisierung als Querschnittsthema
('ICTO-2006', 'ICTO-1001'),  -- Phoenix Rising: Abrechnungssystem braucht IAM
('ICTO-2006', 'ICTO-1008'),  -- Helix Portal: Kundenportal braucht IAM
('ICTO-2006', 'ICTO-2003'),  -- Titan Gateway: API-Gateway braucht IAM
('ICTO-2006', 'ICTO-2005'),  -- NebulaCRM: CRM braucht IAM

-- ── Titan Gateway (ICTO-2003) – API-Gateway / Enterprise-Service-Bus ──────
('ICTO-2003', 'ICTO-1001'),  -- Phoenix Rising: nutzt API-Gateway
('ICTO-2003', 'ICTO-1008'),  -- Helix Portal: nutzt API-Gateway
('ICTO-2003', 'ICTO-1006'),  -- EchoGrid (Abgebrochen ✓ nur Downstream): war über Gateway angebunden

-- ── Polaris Log (ICTO-2002) – Logging & Monitoring ───────────────────────
('ICTO-2002', 'ICTO-2009'),  -- StormWatch: Anomalieerkennung analysiert Logs
('ICTO-2002', 'ICTO-1009'),  -- DawnBreaker: Betrugserkennung nutzt Logs

-- ── Aegis Shield (ICTO-1003) – Zero-Trust-Sicherheitsarchitektur ─────────
('ICTO-1003', 'ICTO-1005'),  -- SilverStream: Cloud-Migration erfordert Zero-Trust
('ICTO-1003', 'ICTO-2003'),  -- Titan Gateway: implementiert Zero-Trust-Policies

-- ── SwiftRoute (ICTO-2007) – BGP/MPLS Traffic-Management ─────────────────
('ICTO-2007', 'ICTO-1007'),  -- Cobalt Connect: 5G-Rollout braucht Traffic-Management
('ICTO-2007', 'ICTO-1004'),  -- Quantum Leap: autonomes Netz-Management braucht Routing

-- ── Ironclad Backbone (ICTO-1010) – Geo-redundantes Failover-System ──────
('ICTO-1010', 'ICTO-1005'),  -- SilverStream: Cloud-Migration setzt stabiles Backbone voraus
('ICTO-1010', 'ICTO-1004'),  -- Quantum Leap: autonomes Management braucht Failover-Garantien

-- ── ClearVault (ICTO-2004) – DSGVO-Dokumentenarchiv ─────────────────────
('ICTO-2004', 'ICTO-1001'),  -- Phoenix Rising: Abrechnungsdaten DSGVO-konform archivieren
('ICTO-2004', 'ICTO-2010'),  -- GlacierStore: Kaltdaten-Archivierung als Erweiterung von ClearVault

-- ── NordStar Analytics (ICTO-1002) – BI-Plattform (Abgeschlossen) ────────
('ICTO-1002', 'ICTO-1004'),  -- Quantum Leap: baut auf etablierten Netzwerkanalysen auf
('ICTO-1002', 'ICTO-2009'),  -- StormWatch: nutzt historische Analysemuster als Baseline

-- ── StormWatch (ICTO-2009) → ChromaDB (Abgebrochen ✓ nur Downstream) ─────
('ICTO-2009', 'ICTO-2008');  -- ChromaDB war Metrik-Speicher für StormWatch (Projekt eingestellt)

ALTER TABLE Abhaengigkeit ENABLE TRIGGER ALL;
