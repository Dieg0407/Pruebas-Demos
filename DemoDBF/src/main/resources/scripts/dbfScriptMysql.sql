drop database if exists testDbf;
create database testDbf;
use testDbf;
create table cpaf0050 (
COD_SUC varchar(4),
COD_ACT varchar(9),
ANT_ACT varchar(10),
DES_ACT varchar(135),
FIN_ACT date,
SGR_ACT varchar(2),
SIG_ACT varchar(1),
VHI_ACT numeric(12,2),
VLI_ACT numeric(12,2),
VTA_ACT numeric(12,2),
VRE_ACT numeric(12,2),
VRP_ACT numeric(12,2),
VTD_ACT numeric(12,2),
VID_ACT numeric(12,2),
FAL_ACT date,
FUD_ACT date,
FDP_ACT numeric(5,2),
VUT_ACT numeric(2,0),
VUM_ACT numeric(12,2),
FUM_ACT date,
VUV_ACT numeric(12,2),
FUV_ACT date,
CTA_ACT varchar(20),
CCO_ACT varchar(10),
LGE_ACT varchar(2),
UOR_ACT varchar(4),
PER_ACT varchar(4),
EST_ACT varchar(2),
TIN_ACT varchar(2),
NDI_ACT varchar(6),
DIN_ACT varchar(2),
PRO_ACT varchar(10),
CAP_ACT varchar(10),
CA1_ACT varchar(100),
CA2_ACT varchar(100),
SER_ACT varchar(100),
SUM_ACT varchar(16),
FBA_ACT date,
HIS_ACT Blob,
TDB_ACT varchar(2),
NDB_ACT varchar(12),
TAB_ACT numeric(12,2),
OBB_ACT varchar(45),
EDO_ACT varchar(1),
FLG_ACT boolean,
SEG_ACT varchar(1),
FEN_ACT date,
FTD_ACT date,
CLASES numeric(2,0),
SERVIC numeric(2,0),
ORICOD numeric(1,0),
TIPREGUL varchar(3),
CODTIPSNT varchar(5),
ACTCURSO numeric(1,0),
KFW numeric(1,0),
DIMEN varchar(200),
DONADOR varchar(150)
);

create table cpaf0001 (
DES_CON varchar(30),
VAR_CON varchar(50),
DBF_CON varchar(8)
);