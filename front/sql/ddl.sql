CREATE TABLE users (
  id number(19) NOT NULL,
  user_division_id char(2) NOT NULL,
  sd_code number(2) NOT NULL,
  sgg_code number(5) NOT NULL,
  badge_id number(19) NOT NULL,
  user_id varchar2(255) NOT NULL,
  password varchar2(255) NOT NULL,
  name varchar(100) NOT NULL,
  nickname varchar2(100) NOT NULL,
  email varchar2(100) NOT NULL,
  birthday varchar2(8) NOT NULL,
  gender char(1) NOT NULL,
  review_score number(2, 1) DEFAULT 0 NOT NULL,
  profile_photo varchar2(255) NULL,
  self_introduction_coment varchar(255) NULL,
  reg_date date DEFAULT sysdate NOT NULL,
  update_date date DEFAULT sysdate NOT NULL,
  last_con_date date DEFAULT sysdate NULL
);

CREATE TABLE class (
  class_id number(19) NOT NULL,
  class_reg_user_id number(19) NOT NULL,
  category_main_id number(2) NOT NULL,
  category_sub_id number(3) NOT NULL,
  sd_code number(2) NOT NULL,
  sgg_code number(5) NOT NULL,
  class_status char(1) NOT NULL,
  title varchar2(255) NOT NULL,
  cinfo varchar2(255) NULL,
  max_std_count number(1) NOT NULL,
  current_std_count number(1) DEFAULT 0 NOT NULL,
  std_gender char(1) DEFAULT 'N' NOT NULL,
  std_age_group char(1) DEFAULT 'N' NOT NULL,
  pay number(10) NOT NULL,
  wish_study_count number(2) DEFAULT 0 NOT NULL,
  wish_days varchar2(20) DEFAULT 'N' NOT NULL,
  lecture_type char(1) DEFAULT 'N' NOT NULL,
  application_count number(5) DEFAULT 0 NOT NULL
);

CREATE TABLE review (
  review_id number(19) NOT NULL,
  schedule_id number(19) NOT NULL,
  id number(19) NOT NULL,
  score number NOT NULL,
  contents varchar2(255) NULL,
  regist_date date DEFAULT sysdate NOT NULL
);

CREATE TABLE recruitment_board (
  recuruitment_id number(19) NOT NULL,
  id number(19) NOT NULL,
  recruitment_board_id char(2) NOT NULL,
  class_id number(19) NOT NULL,
  title varchar2(255) NULL,
  contents varchar2(255) NULL,
  wish_pay varchar2(20) DEFAULT 'N' NOT NULL,
  concern_count number(11) DEFAULT 0 NOT NULL,
  reg_date date DEFAULT sysdate NOT NULL,
  deadline_date date DEFAULT sysdate + 7 NOT NULL
);

CREATE TABLE application_class (
  application_id number(19) NOT NULL,
  id number(19) NOT NULL,
  class_id number(19) NOT NULL,
  accept_yn char(1) DEFAULT 'W' NOT NULL,
  application_contents varchar2(255) NULL,
  reg_date date DEFAULT sysdate NOT NULL
);

CREATE TABLE category_main (
  category_main_id number(2) NOT NULL,
  category_main_name varchar2(255) NULL
);

CREATE TABLE category_sub (
  category_sub_id number(3) NOT NULL,
  category_main_id number(2) NOT NULL,
  category_sub_name varchar2(255) NOT NULL
);

CREATE TABLE concern (
  concern_id number(19) NOT NULL,
  recuruitment_std_id number(19) NOT NULL,
  user_id number(19) NOT NULL,
  concern_date date DEFAULT sysdate NOT NULL
);

CREATE TABLE point (
  point_id number(19) NOT NULL,
  id number(19) NOT NULL,
  point_create_date date DEFAULT sysdate NOT NULL,
  point_value number(19) NULL,
  point_type varchar2(255) NULL,
  point_contents varchar2(255) NULL,
  point_use char(1) NULL
);

CREATE TABLE recruitment_board_type (
  recruitment_board_id char(2) NOT NULL,
  board_name varchar2(100) NOT NULL,
  board_info varchar2(255) NULL
);

CREATE TABLE matching_class (
  class_id number(19) NOT NULL,
  id number(19) NOT NULL,
  user_division char(1) NOT NULL
);

CREATE TABLE user_division (
  user_division_id char(2) NOT NULL,
  user_division_name varchar2(100) NOT NULL
);

CREATE TABLE region_sd (
  sd_code number(2) NOT NULL,
  sd_name varchar2(30) NOT NULL
);

CREATE TABLE region_sgg (
  sgg_code number(5) NOT NULL,
  sgg_name varchar2(30) NOT NULL
);

CREATE TABLE region_emd (
  emd_code number(5) NOT NULL,
  emd_name varchar2(30) NOT NULL
);

CREATE TABLE class_scedule (
  scedule_id number(19) NOT NULL,
  class_id number(19) NOT NULL,
  class_date Date NOT NULL,
  class_notice varchar2(255) NULL
);

CREATE TABLE badge (
  badge_id number(19) NOT NULL,
  badge_name char(1) NOT NULL,
  badge_image_file_path varchar(225) NOT NULL
);

ALTER TABLE
  users
ADD
  CONSTRAINT PK_users PRIMARY KEY (
    id
  );

ALTER TABLE
  class
ADD
  CONSTRAINT PK_class PRIMARY KEY (
    class_id
  );

ALTER TABLE
  review
ADD
  CONSTRAINT PK_review PRIMARY KEY (
    review_id
  );

ALTER TABLE
  recruitment_board
ADD
  CONSTRAINT PK_RECRUITMENT_BOARD PRIMARY KEY (
    recuruitment_id
  );

ALTER TABLE
  application_class
ADD
  CONSTRAINT PK_application_class PRIMARY KEY (
    application_id
  );

ALTER TABLE
  category_main
ADD
  CONSTRAINT PK_category_main PRIMARY KEY (
    category_main_id
  );

ALTER TABLE
  category_sub
ADD
  CONSTRAINT PK_category_sub PRIMARY KEY (
    category_sub_id
  );

ALTER TABLE
  concern
ADD
  CONSTRAINT PK_CONCERN PRIMARY KEY (
    concern_id
  );

ALTER TABLE
  point
ADD
  CONSTRAINT PK_point PRIMARY KEY (
    point_id
  );

ALTER TABLE
  recruitment_board_type
ADD
  CONSTRAINT PK_RECRUITMENT_BOARD_TYPE PRIMARY KEY (
    recruitment_board_id
  );

ALTER TABLE
  user_division
ADD
  CONSTRAINT PK_USER_DIVISION PRIMARY KEY (
    user_division_id
  );

ALTER TABLE
  region_sd
ADD
  CONSTRAINT PK_region_sd PRIMARY KEY (
    sd_code
  );

ALTER TABLE
  region_sgg
ADD
  CONSTRAINT PK_region_sgg PRIMARY KEY (
    sgg_code
  );

ALTER TABLE
  class_scedule
ADD
  CONSTRAINT PK_class_SCEDULE PRIMARY KEY (
    scedule_id
  );

ALTER TABLE
  badge
ADD
  CONSTRAINT PK_BADGE PRIMARY KEY (
    badge_id
  );

ALTER TABLE
  users
ADD
  CONSTRAINT FK_user_division_TO_users_1 FOREIGN KEY (
    user_division_id
  ) REFERENCES user_division (
    user_division_id
  );

ALTER TABLE
  users
ADD
  CONSTRAINT FK_region_sd_TO_users_1 FOREIGN KEY (
    sd_code
  ) REFERENCES region_sd (
    sd_code
  );

ALTER TABLE
  users
ADD
  CONSTRAINT FK_region_sgg_TO_users_1 FOREIGN KEY (
    sgg_code
  ) REFERENCES region_sgg (
    sgg_code
  );

ALTER TABLE
  users
ADD
  CONSTRAINT FK_badge_TO_users_1 FOREIGN KEY (
    badge_id
  ) REFERENCES badge (
    badge_id
  );

ALTER TABLE
  class
ADD
  CONSTRAINT FK_users_TO_class_1 FOREIGN KEY (
    class_reg_user_id
  ) REFERENCES users (id);

ALTER TABLE
  class
ADD
  CONSTRAINT FK_category_main_TO_class_1 FOREIGN KEY (
    category_main_id
  ) REFERENCES category_main (
    category_main_id
  );

ALTER TABLE
  class
ADD
  CONSTRAINT FK_category_sub_TO_class_1 FOREIGN KEY (
    category_sub_id
  ) REFERENCES category_sub (
    category_sub_id
  );

ALTER TABLE
  class
ADD
  CONSTRAINT FK_region_sd_TO_class_1 FOREIGN KEY (
    sd_code
  ) REFERENCES region_sd (
    sd_code
  );

ALTER TABLE
  class
ADD
  CONSTRAINT FK_region_sgg_TO_class_1 FOREIGN KEY (
    sgg_code
  ) REFERENCES region_sgg (
    sgg_code
  );

ALTER TABLE
  review
ADD
  CONSTRAINT FK_class_TO_review_1 FOREIGN KEY (
    schedule_id
  ) REFERENCES class (
    class_id
  );

ALTER TABLE
  review
ADD
  CONSTRAINT FK_users_TO_review_1 FOREIGN KEY (
    id
  ) REFERENCES users (id);

ALTER TABLE
  recruitment_board
ADD
  CONSTRAINT FK_users_TO_recruitment_board_1 FOREIGN KEY (
    id
  ) REFERENCES users (id);

ALTER TABLE
  recruitment_board
ADD
  CONSTRAINT FK_recruitment_board_type_TO_recruitment_board_1 FOREIGN KEY (
    recruitment_board_id
  ) REFERENCES recruitment_board_type (
    recruitment_board_id
  );

ALTER TABLE
  recruitment_board
ADD
  CONSTRAINT FK_class_TO_recruitment_board_1 FOREIGN KEY (
    class_id
  ) REFERENCES class (
    class_id
  );

ALTER TABLE
  application_class
ADD
  CONSTRAINT FK_users_TO_application_class_1 FOREIGN KEY (
    id
  ) REFERENCES users (id);

ALTER TABLE
  application_class
ADD
  CONSTRAINT FK_class_TO_application_class_1 FOREIGN KEY (
    class_id
  ) REFERENCES class (
    class_id
  );

ALTER TABLE
  category_sub
ADD
  CONSTRAINT FK_category_main_TO_category_sub_1 FOREIGN KEY (
    category_main_id
  ) REFERENCES category_main (
    category_main_id
  );

ALTER TABLE
  concern
ADD
  CONSTRAINT FK_recruitment_board_TO_Concern_1 FOREIGN KEY (
    recuruitment_std_id
  ) REFERENCES recruitment_board (
    recuruitment_id
  );

ALTER TABLE
  concern
ADD
  CONSTRAINT FK_users_TO_Concern_1 FOREIGN KEY (
    user_id
  ) REFERENCES users (id);

ALTER TABLE
  point
ADD
  CONSTRAINT FK_users_TO_point_1 FOREIGN KEY (
    id
  ) REFERENCES users (id);

ALTER TABLE
  class_scedule
ADD
  CONSTRAINT FK_class_TO_class_scedule_1 FOREIGN KEY (
    class_id
  ) REFERENCES class (
    class_id
  );