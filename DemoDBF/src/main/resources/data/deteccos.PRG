SET DELETED ON
SET EXCLUSIVE OFF
SET SAFETY OFF
USE cpaf0050 IN 1 SHARED
USE f:\avalon\costos\data\cct0004 IN 2 shared
SELECT 1
SCAN FOR cod_suc="0106"
   x1=ALLTRIM(cco_act)
   SELECT 2
   LOCATE FOR ALLTRIM(ccta)=x1
   IF !FOUND() THEN 
      ? x1
   endif
   SELECT 1
ENDSCAN
CLOSE TABLES all
      