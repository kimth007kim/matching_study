


delete from category;
INSERT INTO Category
    (category_id,category_name,category_parent_id,description)VALUES
  (1,'스터디',NULL,NULL ),
  (2,'취미',NULL,NULL),
  (3,'어학',1, '(토플/토익)'),
  (4,'취업',1, '(면접/자소서)'),
  (5,'고시/공무원',1, NULL ),
  (6,'프로젝트',1, '(디자인/개발)'),
  (7,'기타',1, '(여기에 없어요!)'),
  (8,'예술',2, '(공예/회화)'),
  (9,'요리',2, '(요리/맛집탐방/카페탐방)'),
  (10,'운동',2, '(헬스/구기종목)'),
  (11,'게임',2, '(보드게임/온라인 게임)'),
  (12,'덕질',2, '(코스프레/콘서트/프라모델)'),
  (13,'트렌드',2, '(뷰티/패션)'),
  (14,'기타',2, '(여기에 없어요!)');