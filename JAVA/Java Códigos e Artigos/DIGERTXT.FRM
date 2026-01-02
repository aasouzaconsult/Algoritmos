/dirf02
FAE - GERADOR DE ARQUIVO TEXTO PARA ANALISADOR DIRF  (DIGERTXT.FRM)   __/__/____
================================================================================





               Ano Base para DIRF...........: ____

               (O)riginal ou (R)etificadora ? _


               Confirma (S/N) ? _
               

               ______________________________


               

================================================================================
F1-Encerrar
================================================================================
/reg1
_____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________
___________________________________________
/reg2
_____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________
___________________________________________
******
/reg3
_____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________
___________________________________________
/*
USE Y2K
#INCLUDE ifx.top
#INCLUDE whilex.top

open "/aplic/folha/arqfp/fgts95/fpsefip" as fpsefip
zerofile fpsefip
open dirf

//----Variaveis
  string wanomes1 6 wanomes2 6 wano 4
  string wbr13 13 wbr48 48 wbr8 8 wbr37 37 wbr41 41 wbr47 47
  string wbr1 9 wbr2 48 wbr4 67 wbr5 43 wcpf1 11 wpes 1 wsnome 60 wnome 40
  string wmatr 4 wcpfcgc 14 wtipo 1 wcpfcgc1 14 wzero 15 wzero1 15 wzero2 15
  string waux 15 waux1 15 wsr 15 wsd 15 wsi 15
  string ws1 45 ws2 45 ws3 45 ws4 45 ws5 45 ws6 45 ws7 45 ws8 45 ws9 45
  string ws10 45 ws11 45 ws12 45 ws13 45 wtecla
  string wreg11 237 wreg12 225 wreg13 225 wreg14 43 wreg21 237 wreg22 225 wreg23 225 wreg31 237 wreg32 225 wreg33 225
  string wstr1 15 wstr2 15 wstr3 15 wstr4 15 wstr5 15 wstr6 15 wstr7 15
  string wstr8 15 wstr9 15 wstr10 15 wstr11 15 wstr12 15 wstr13 15
  string wstd1 15 wstd2 15 wstd3 15 wstd4 15 wstd5 15 wstd6 15 wstd7 15
  string wstd8 15 wstd9 15 wstd10 15 wstd11 15 wstd12 15 wstd13 15
  string wsti1 15 wsti2 15 wsti3 15 wsti4 15 wsti5 15 wsti6 15 wsti7 15
  string wsti8 15 wsti9 15 wsti10 15 wsti11 15 wsti12 15 wsti13 15
  string wscont 8 wnumreg 8 wcgc 14 wcod 4 wstot2 8 wmes 2 wbr199 199 wbr43
 
  integer wcont2 wtipo1 wtipo2 wtipo3 wcont wqtdz wcont1 wtam

  number wtr1 wtr2 wtr3 wtr4 wtr5 wtr6 wtr7 wtr8 wtr9 wtr10 wtr11 wtr12
  number wtr13 wtd1 wtd2 wtd3 wtd4 wtd5 wtd6 wtd7 wtd8 wtd9 wtd10 wtd11
  number wtd12 wtd13 wti1 wti2 wti3 wti4 wti5 wti6 wti7 wti8 wti9 wti10 
  number wti11 wti12 wti13 wr wd wi 

  number  wtra1  wtra2 wtra3 wtra4 wtra5 wtra6 wtra7 wtra8 wtra9  wtra10  wtra11
  number  wtra12 wtra13 wtda1 wtda2 wtda3 wtda4 wtda5 wtda6 wtda7  wtda8  wtda9
  number  wtda10 wtda11 wtda12 wtda13 wtia1 wtia2 wtia3 wtia4 wtia5 wtia6  wtia7
  number  wtia8 wtia9 wtia10 wtia11 wtia12 wtia13  

move '         ' to wbr1
move '                                                ' to wbr2
move '                                                                   ' to wbr4
move '                                           ' to wbr5
move 0 to wtipo1
move 0 to wtipo2
move 0 to wtipo3
move '                                                                                                                                                                                                       ' to wbr199
move '                                           ' to wbr43
move '                                         ' to wbr41

//----
move '             ' to wbr13   
move '                                               ' to wbr47
move '                                                ' to wbr48
move '                                     ' to wbr37
move '        ' to wbr8
clearscreen
page set dirf02 at 00 00

autopage dirf02
name jdate jano jdirf jconf jmens
sysdate jdate

volta:
accept jano   {required,autoreturn}
[key.escape] abort

move '' to wanomes1
append wanomes1 jano '01'
move '' to wanomes2
append wanomes2 jano '13'
mid jano to wano 4 1

accept jdirf    {required,capslock,autoreturn,check='OeR'}
[key.escape] abort

accept jconf    {required,capslock,autoreturn,check='SeN'}
[key.escape] abort
if jconf eq 'N' abort


move 'Aguarde Final de Processamento' to jmens

move 10000 to pageend
move 0     to pagefeed
outfile "dirf.txt" 
      
move 1 to wcont 

clear dirf
move '07281413000130' to dirf.cgc
find ge dirf by index.1
whilex [found] AND dirf.cgc in '07281413000130'
   move dirf.cgc to wcgc
   movestr wcont to wscont  
   move '' to wnumreg 
   if wcont le 9 append wnumreg '0000000'  wscont
   ifx wcont le 99 AND wcont ge 10 append wnumreg '000000'  wscont
   ifx wcont le 999 AND wcont ge 100 append wnumreg '00000'  wscont
   ifx wcont le 9999 AND wcont ge 1000 append wnumreg '0000'  wscont
   ifx wcont le 99999 AND wcont ge 10000 append wnumreg '000'  wscont
   ifx wcont le 999999 AND wcont ge 100000 append wnumreg '00'  wscont
   ifx wcont le 9999999 AND wcont ge 1000000 append wnumreg '0'  wscont
   if  wcont ge 10000000 move wscont to wnumreg      
   increment wcont 
   
//---Montar registro 1
   reread
     clear fpsefip
     append fpsefip.linhadirf wnumreg '1' wcgc 'DIRF' wano jdirf '1200' wano '  FAE FERRAGENS E APARELHOS ELETRICOS S/A.                    '
     append fpsefip.linhadirf '13876773490' wbr37 '07281413000130 ' wbr48 wbr48 wbr48 wbr48 wbr48 '01387677349ACACIO ARAUJO DE VASCONCELOS                                '
     append fpsefip.linhadirf '00850216170400000002293246fae@fae.com.br                                    '
     append fpsefip.linhadirf wbr47 wbr48 wbr48 wbr13 wbr8 wbr13 '9'
     saverecord fpsefip
   unlock
   increment wtipo1
   whilex [found] AND dirf.cgc eq wcgc           
    move dirf.coddarf to wcod
    move 0.00 to wtr1
    move 0.00 to wtr2
    move 0.00 to wtr3
    move 0.00 to wtr4
    move 0.00 to wtr5
    move 0.00 to wtr6
    move 0.00 to wtr7
    move 0.00 to wtr8
    move 0.00 to wtr9
    move 0.00 to wtr10
    move 0.00 to wtr11
    move 0.00 to wtr12
    move 0.00 to wtr13
    move 0.00 to wti1
    move 0.00 to wti2
    move 0.00 to wti3
    move 0.00 to wti4
    move 0.00 to wti5
    move 0.00 to wti6
    move 0.00 to wti7
    move 0.00 to wti8
    move 0.00 to wti9
    move 0.00 to wti10
    move 0.00 to wti11
    move 0.00 to wti12
    move 0.00 to wti13
    move 0.00 to wtd1
    move 0.00 to wtd2
    move 0.00 to wtd3
    move 0.00 to wtd4
    move 0.00 to wtd5
    move 0.00 to wtd6
    move 0.00 to wtd7
    move 0.00 to wtd8
    move 0.00 to wtd9
    move 0.00 to wtd10
    move 0.00 to wtd11
    move 0.00 to wtd12
    move 0.00 to wtd13     
    move 0 to wcont2
    indicate wentr2 false
    whilex [found] AND dirf.cgc eq wcgc AND dirf.coddarf eq wcod 
      movestr wcont to wscont  
      move '' to wnumreg 
      if wcont le 9 append wnumreg '0000000'  wscont
      ifx wcont le 99 AND wcont ge 10 append wnumreg '000000'  wscont
      ifx wcont le 999 AND wcont ge 100 append wnumreg '00000'  wscont
      ifx wcont le 9999 AND wcont ge 1000 append wnumreg '0000'  wscont
      ifx wcont le 99999 AND wcont ge 10000 append wnumreg '000'  wscont
      ifx wcont le 999999 AND wcont ge 100000 append wnumreg '00'  wscont
      ifx wcont le 9999999 AND wcont ge 1000000 append wnumreg '0'  wscont
      if wcont ge 10000000 move wscont to wnumreg      
      move dirf.cpfcgc to wcpfcgc1
      move dirf.tipo   to wtipo 
      if dirf.tipo eq 'F' begin
         move '1' to wpes     
         mid dirf.cpfcgc to wcpf1 11 1
         move '' to wcpfcgc 
         append wcpfcgc '000' wcpf1
      end     
      else begin
         move '2' to wpes            
         move dirf.cpfcgc to wcpfcgc
      end
      move dirf.nome to wnome 
      move '' to wsnome
      append wsnome wnome '                    '
      move dirf.matr to wmatr
      move '000000000000000000000000000000000000000000000' to ws1
      move '000000000000000000000000000000000000000000000' to ws2
      move '000000000000000000000000000000000000000000000' to ws3
      move '000000000000000000000000000000000000000000000' to ws4
      move '000000000000000000000000000000000000000000000' to ws5
      move '000000000000000000000000000000000000000000000' to ws6
      move '000000000000000000000000000000000000000000000' to ws7
      move '000000000000000000000000000000000000000000000' to ws8
      move '000000000000000000000000000000000000000000000' to ws9
      move '000000000000000000000000000000000000000000000' to ws10
      move '000000000000000000000000000000000000000000000' to ws11
      move '000000000000000000000000000000000000000000000' to ws12
      move '000000000000000000000000000000000000000000000' to ws13
      indicate wentr1 false 

      move 0.00 to wtra1
      move 0.00 to wtra2
      move 0.00 to wtra3
      move 0.00 to wtra4
      move 0.00 to wtra5
      move 0.00 to wtra6
      move 0.00 to wtra7
      move 0.00 to wtra8
      move 0.00 to wtra9
      move 0.00 to wtra10
      move 0.00 to wtra11
      move 0.00 to wtra12
      move 0.00 to wtra13
      move 0.00 to wtia1
      move 0.00 to wtia2
      move 0.00 to wtia3
      move 0.00 to wtia4
      move 0.00 to wtia5
      move 0.00 to wtia6
      move 0.00 to wtia7
      move 0.00 to wtia8
      move 0.00 to wtia9
      move 0.00 to wtia10
      move 0.00 to wtia11
      move 0.00 to wtia12
      move 0.00 to wtia13
      move 0.00 to wtda1
      move 0.00 to wtda2
      move 0.00 to wtda3
      move 0.00 to wtda4
      move 0.00 to wtda5
      move 0.00 to wtda6
      move 0.00 to wtda7
      move 0.00 to wtda8
      move 0.00 to wtda9
      move 0.00 to wtda10
      move 0.00 to wtda11
      move 0.00 to wtda12
      move 0.00 to wtda13     

      whilex [found] AND dirf.cgc eq wcgc AND dirf.coddarf eq wcod AND dirf.tipo eq wtipo AND dirf.cpfcgc eq wcpfcgc1
      ifx dirf.anomes ge wanomes1 AND dirf.anomes le wanomes2 begin 
         mid dirf.anomes to wmes 2 5
         move (dirf.totrend*100) to wr                       
         move (dirf.deducao*100) to wd
         move (dirf.imposto*100) to wi          
         ifx wi ne 0.00 indicate wentr1 true
//wcgc eq '63554067000198' 
         if  wr eq 0 move '00000000000000' to wzero 
         ifx wr le 9 AND wr gt 0 move '00000000000000' to wzero
         ifx wr le 99 AND wr ge 10 move '0000000000000' to wzero
         ifx wr le 999 AND wr ge 100 move '000000000000' to wzero
         ifx wr le 9999 AND wr ge 1000 move '00000000000' to wzero
         ifx wr le 99999 AND wr ge 10000 move '0000000000' to wzero
         ifx wr le 999999 AND wr ge 100000 move '000000000' to wzero
         ifx wr le 9999999 AND wr ge 1000000 move '00000000' to wzero
         ifx wr le 99999999 AND wr ge 10000000 move '0000000' to wzero
         ifx wr ge 100000000 move '000000' to wzero       
         if wd eq 0 move '00000000000000' to wzero1
         ifx wd le 9 AND wd gt 0 move '00000000000000' to wzero1
         ifx wd le 99 AND wd ge 10 move '0000000000000' to wzero1
         ifx wd le 999 AND wd ge 100 move '000000000000' to wzero1
         ifx wd le 9999 AND wd ge 1000 move '00000000000' to wzero1 
         ifx wd le 99999 AND wd ge 10000 move '0000000000' to wzero1
         ifx wd le 999999 AND wd ge 100000 move '000000000' to wzero1
         ifx wd le 9999999 AND wd ge 1000000 move '00000000' to wzero1
         ifx wd le 99999999 AND wd ge 10000000 move '0000000' to wzero1
         ifx wd ge 100000000 move '000000' to wzero1         
         if wi eq 0 move '00000000000000' to wzero2
         ifx wi le 9 AND wi gt 0 move '00000000000000' to wzero2
         ifx wi le 99 AND wi ge 10 move '0000000000000' to wzero2
         ifx wi le 999 AND wi ge 100 move '000000000000' to wzero2
         ifx wi le 9999 AND wi ge 1000 move '00000000000' to wzero2
         ifx wi le 99999 AND wi ge 10000 move '0000000000' to wzero2
         ifx wi le 999999 AND wi ge 100000 move '000000000' to wzero2
         ifx wi le 9999999 AND wi ge 1000000 move '00000000' to wzero2
         ifx wi le 99999999 AND wi ge 10000000 move '0000000' to wzero2
         ifx wi ge 100000000 move '000000' to wzero2 
         movestr wr to wsr
         movestr wd to wsd
         movestr wi to wsi
         trim wsi to wsi
         trim wsd to wsd
         trim wsr to wsr
         if wmes eq '01' begin                    
            move '' to ws1
            append ws1 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra1
            move (dirf.deducao) to wtda1
            move (dirf.imposto) to wtia1 
         end 
         if wmes eq '02' begin
            move '' to ws2
            append ws2 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra2
            move (dirf.deducao) to wtda2 
            move (dirf.imposto) to wtia2  
         end
         if wmes eq '03' begin                    
            move '' to ws3
            append ws3 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra3
            move (dirf.deducao) to wtda3 
            move (dirf.imposto) to wtia3  
         end 
         if wmes eq '04' begin
            move '' to ws4
            append ws4 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra4
            move (dirf.deducao) to wtda4
            move (dirf.imposto) to wtia4  
         end
         if wmes eq '05' begin                    
            move '' to ws5
            append ws5 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra5
            move (dirf.deducao) to wtda5 
            move (dirf.imposto) to wtia5  
         end 
         if wmes eq '06' begin
            move '' to ws6
            append ws6 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra6 
            move (dirf.deducao) to wtda6 
            move (dirf.imposto) to wtia6  
         end
         if wmes eq '07' begin                    
            move '' to ws7
            append ws7 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra7 
            move (dirf.deducao) to wtda7 
            move (dirf.imposto) to wtia7  
         end 
         if wmes eq '08' begin
            move '' to ws8
            append ws8 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra8 
            move (dirf.deducao) to wtda8 
            move (dirf.imposto) to wtia8  
         end
         if wmes eq '09' begin                    
            move '' to ws9
            append ws9 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra9
            move (dirf.deducao) to wtda9
            move (dirf.imposto) to wtia9  
         end 
         if wmes eq '10' begin
            move '' to ws10
            append ws10 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra10 
            move (dirf.deducao) to wtda10 
            move (dirf.imposto) to wtia10  
         end
         if wmes eq '11' begin                    
            move '' to ws11
            append ws11 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra11 
            move (dirf.deducao) to wtda11 
            move (dirf.imposto) to wtia11  
         end 
         if wmes eq '12' begin
            move '' to ws12
            append ws12 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra12 
            move (dirf.deducao) to wtda12 
            move (dirf.imposto) to wtia12  
         end          
         if wmes eq '13' begin
            move '' to ws13
            append ws13 wzero wsr wzero1 wsd wzero2 wsi
            move (dirf.totrend) to wtra13 
            move (dirf.deducao) to wtda13 
            move (dirf.imposto) to wtia13  
         end
      end
      find gt dirf by index.1
      end
      [wentr1] begin
         indicate wentr2 true
         move (wtr1 + wtra1) to wtr1
         move (wtd1 + wtda1) to wtd1
         move (wti1 + wtia1) to wti1 
         move (wtr2 + wtra2) to wtr2
         move (wtd2 + wtda2) to wtd2 
         move (wti2 + wtia2) to wti2  
         move (wtr3 + wtra3) to wtr3
         move (wtd3 + wtda3) to wtd3 
         move (wti3 + wtia3) to wti3  
         move (wtr4 + wtra4) to wtr4
         move (wtd4 + wtda4) to wtd4
         move (wti4 + wtia4) to wti4  
         move (wtr5 + wtra5) to wtr5
         move (wtd5 + wtda5) to wtd5 
         move (wti5 + wtia5) to wti5  
         move (wtr6 + wtra6) to wtr6 
         move (wtd6 + wtda6) to wtd6 
         move (wti6 + wtia6) to wti6  
         move (wtr7 + wtra7) to wtr7 
         move (wtd7 + wtda7) to wtd7 
         move (wti7 + wtia7) to wti7  
         move (wtr8 + wtra8) to wtr8 
         move (wtd8 + wtda8) to wtd8 
         move (wti8 + wtia8) to wti8  
         move (wtr9 + wtra9) to wtr9
         move (wtd9 + wtda9) to wtd9
         move (wti9 + wtia9) to wti9  
         move (wtr10 + wtra10) to wtr10 
         move (wtd10 + wtda10) to wtd10 
         move (wti10 + wtia10) to wti10  
         move (wtr11 + wtra11) to wtr11 
         move (wtd11 + wtda11) to wtd11 
         move (wti11 + wtia11) to wti11  
         move (wtr12 + wtra12) to wtr12 
         move (wtd12 + wtda12) to wtd12 
         move (wti12 + wtia12) to wti12  
         move (wtr13 + wtra13) to wtr13 
         move (wtd13 + wtda13) to wtd13 
         move (wti13 + wtia13) to wti13  
         
         reread
            clear fpsefip
            append fpsefip.linhadirf wnumreg '2' wcgc wcod wpes wcpfcgc wsnome ws1 ws2 ws3 
            append fpsefip.linhadirf ws4 ws5 ws6 ws7 ws8 
            append fpsefip.linhadirf ws9 ws10 ws11 ws12 ws13 '0' wbr41 '9'
            saverecord fpsefip
         unlock
         increment wtipo2
         increment wcont2
         increment wcont
      end    
    end
    [wentr2] begin
       movestr wcont to wscont  
       move '' to wnumreg 
       if wcont le 9 append wnumreg '0000000'  wscont
       ifx wcont le 99 AND wcont ge 10 append wnumreg '000000'  wscont
       ifx wcont le 999 AND wcont ge 100 append wnumreg '00000'  wscont
       ifx wcont le 9999 AND wcont ge 1000 append wnumreg '0000'  wscont
       ifx wcont le 99999 AND wcont ge 10000 append wnumreg '000'  wscont
       ifx wcont le 999999 AND wcont ge 100000 append wnumreg '00'  wscont
       ifx wcont le 9999999 AND wcont ge 1000000 append wnumreg '0'  wscont
       if wcont ge 10000000 move wscont to wnumreg      
       increment wcont                          
       movestr (wtr1*100) to wstr1
       movestr (wtr2*100) to wstr2
       movestr (wtr3*100) to wstr3
       movestr (wtr4*100) to wstr4
       movestr (wtr5*100) to wstr5
       movestr (wtr6*100) to wstr6
       movestr (wtr7*100) to wstr7
       movestr (wtr8*100) to wstr8
       movestr (wtr9*100) to wstr9
       movestr (wtr10*100) to wstr10
       movestr (wtr11*100) to wstr11
       movestr (wtr12*100) to wstr12
       movestr (wtr13*100) to wstr13
       movestr (wtd1*100) to wstd1
       movestr (wtd2*100) to wstd2
       movestr (wtd3*100) to wstd3
       movestr (wtd4*100) to wstd4
       movestr (wtd5*100) to wstd5
       movestr (wtd6*100) to wstd6
       movestr (wtd7*100) to wstd7
       movestr (wtd8*100) to wstd8
       movestr (wtd9*100) to wstd9
       movestr (wtd10*100) to wstd10
       movestr (wtd11*100) to wstd11
       movestr (wtd12*100) to wstd12
       movestr (wtd13*100) to wstd13
       movestr (wti1*100) to wsti1
       movestr (wti2*100) to wsti2
       movestr (wti3*100) to wsti3
       movestr (wti4*100) to wsti4
       movestr (wti5*100) to wsti5
       movestr (wti6*100) to wsti6
       movestr (wti7*100) to wsti7
       movestr (wti8*100) to wsti8
       movestr (wti9*100) to wsti9
       movestr (wti10*100) to wsti10
       movestr (wti11*100) to wsti11
       movestr (wti12*100) to wsti12
       movestr (wti13*100) to wsti13
       move wstr1 to waux
       gosub inczero   
       move waux1 to wstr1
       move wstr2 to waux
       gosub inczero   
       move waux1 to wstr2
       move wstr3 to waux
       gosub inczero   
       move waux1 to wstr3
       move wstr4 to waux
       gosub inczero   
       move waux1 to wstr4
       move wstr5 to waux
       gosub inczero   
       move waux1 to wstr5
       move wstr6 to waux
       gosub inczero   
       move waux1 to wstr6
       move wstr7 to waux
       gosub inczero   
       move waux1 to wstr7
       move wstr8 to waux
       gosub inczero   
       move waux1 to wstr8
       move wstr9 to waux
       gosub inczero   
       move waux1 to wstr9
       move wstr10 to waux
       gosub inczero   
       move waux1 to wstr10 
       move wstr11 to waux
       gosub inczero   
       move waux1 to wstr11
       move wstr12 to waux
       gosub inczero   
       move waux1 to wstr12 
       move wstr13 to waux
       gosub inczero   
       move waux1 to wstr13 
       move wstd1 to waux
       gosub inczero   
       move waux1 to wstd1
       move wstd2 to waux
       gosub inczero   
       move waux1 to wstd2
       move wstd3 to waux
       gosub inczero   
       move waux1 to wstd3
       move wstd4 to waux
       gosub inczero   
       move waux1 to wstd4
       move wstd5 to waux
       gosub inczero   
       move waux1 to wstd5
       move wstd6 to waux
       gosub inczero   
       move waux1 to wstd6
       move wstd7 to waux
       gosub inczero   
       move waux1 to wstd7
       move wstd8 to waux
       gosub inczero   
       move waux1 to wstd8
       move wstd9 to waux
       gosub inczero   
       move waux1 to wstd9
       move wstd10 to waux
       gosub inczero   
       move waux1 to wstd10 
       move wstd11 to waux
       gosub inczero   
       move waux1 to wstd11 
       move wstd12 to waux
       gosub inczero   
       move waux1 to wstd12 
       move wstd13 to waux
       gosub inczero   
       move waux1 to wstd13 
       move wsti1 to waux
       gosub inczero   
       move waux1 to wsti1
       move wsti2 to waux
       gosub inczero   
       move waux1 to wsti2
       move wsti3 to waux
       gosub inczero   
       move waux1 to wsti3
       move wsti4 to waux
       gosub inczero   
       move waux1 to wsti4
       move wsti5 to waux
       gosub inczero   
       move waux1 to wsti5
       move wsti6 to waux
       gosub inczero   
       move waux1 to wsti6
       move wsti7 to waux
       gosub inczero   
       move waux1 to wsti7
       move wsti8 to waux
       gosub inczero   
       move waux1 to wsti8
       move wsti9 to waux
       gosub inczero   
       move waux1 to wsti9
       move wsti10 to waux
       gosub inczero   
       move waux1 to wsti10 
       move wsti11 to waux
       gosub inczero   
       move waux1 to wsti11 
       move wsti12 to waux
       gosub inczero   //----aqui tinha duas barras
       move waux1 to wsti12 
       move wsti13 to waux
       gosub inczero    //----aqui tinha duas barras
       move waux1 to wsti13    
       movestr wcont2 to waux
       gosub inczero1    //----aqui tinha duas barras
       move waux1 to wstot2
         
       move '' to ws1
       move '' to ws2
       move '' to ws3
       move '' to ws4
       move '' to ws5
       move '' to ws6
       move '' to ws7
       move '' to ws8
       move '' to ws9
       move '' to ws10
       move '' to ws11
       move '' to ws12
       move '' to ws13
       append ws1 wstr1 wstd1 wsti1
       append ws2 wstr2 wstd2 wsti2
       append ws3 wstr3 wstd3 wsti3
       append ws4 wstr4 wstd4 wsti4
       append ws5 wstr5 wstd5 wsti5
       append ws6 wstr6 wstd6 wsti6
       append ws7 wstr7 wstd7 wsti7
       append ws8 wstr8 wstd8 wsti8
       append ws9 wstr9 wstd9 wsti9
       append ws10 wstr10 wstd10 wsti10
       append ws11 wstr11 wstd11 wsti11
       append ws12 wstr12 wstd12 wsti12
       append ws13 wstr13 wstd13 wsti13
       //---aqui tinha dus barras
       reread
          clear fpsefip
          append fpsefip.linhadirf wnumreg '3' wcgc wcod wstot2 wbr4 ws1 ws2 ws3 
          append fpsefip.linhadirf ws4 ws5 ws6 ws7 ws8 
          append fpsefip.linhadirf ws9 ws10 ws11 ws12 ws13 wbr41 ' 9'
          saverecord fpsefip
       unlock
       increment wtipo3                       //---aqui tinha dus barras
    end   
   end
end

clear fpsefip
find gt fpsefip by recnum
while [found]
   writeln fpsefip.linhadirf
   find gt fpsefip by recnum
end   

gotoxy 16 16
show 'Tipo1: '
showln wtipo1
gotoxy 17 16
show 'Tipo2: '
showln wtipo2
gotoxy 18 16
show 'Tipo3: '
showln wtipo3
inkey wtecla

abort

inczero:
   trim waux to waux
   length waux to wtam
   move (15-wtam) to wqtdz
   move '' to waux1 
   if wqtdz eq 0 move waux to waux1 
   if wqtdz eq 1 append waux1 '0' waux
   if wqtdz eq 2 append waux1 '00' waux
   if wqtdz eq 3 append waux1 '000' waux
   if wqtdz eq 4 append waux1 '0000' waux
   if wqtdz eq 5 append waux1 '00000' waux
   if wqtdz eq 6 append waux1 '000000' waux
   if wqtdz eq 7 append waux1 '0000000' waux
   if wqtdz eq 8 append waux1 '00000000' waux
   if wqtdz eq 9 append waux1 '000000000' waux
   if wqtdz eq 10 append waux1 '0000000000' waux
   if wqtdz eq 11 append waux1 '00000000000' waux
   if wqtdz eq 12 append waux1 '000000000000' waux
   if wqtdz eq 13 append waux1 '0000000000000' waux
   if wqtdz eq 14 append waux1 '00000000000000' waux
return 
                 
inczero1:
   trim waux to waux
   length waux to wtam
   move (8-wtam) to wqtdz
   move '' to waux1 
   if wqtdz eq 0 move waux to waux1 
   if wqtdz eq 1 append waux1 '0' waux
   if wqtdz eq 2 append waux1 '00' waux
   if wqtdz eq 3 append waux1 '000' waux
   if wqtdz eq 4 append waux1 '0000' waux
   if wqtdz eq 5 append waux1 '00000' waux
   if wqtdz eq 6 append waux1 '000000' waux
   if wqtdz eq 7 append waux1 '0000000' waux
return 
                 
    
    
   
 
 
 
 
 
 
