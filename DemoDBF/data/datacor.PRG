set dele on 
set exclu off
set safety off
suspend
use cpaf0050 in 1
use cpaf0080 in 2
sele 1
go top
scan for cod_suc="1003"
  xac=allt(cod_act)
  sele 2
  locate for (allt(cod_dep)=xac and per_dep="2005" and cod_suc="1003")
  if found() then
    xdep=depacu12
  else
    xdep=0.00
  endif
  sele 1
  replace vtd_act with xdep     
endscan
close tables all