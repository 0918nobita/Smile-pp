' PROJECT SMILE++
' Smile++ Transpiler 2017.1

option strict

acls
prgEdit 1

' 配列の要素を検索する

def indexOf$(array$[], string$)
	var i
	for i = 0 to len(array$) - 1
		if array$[i] == string$ then return i
	next
	return -1
end

' 配列を生成する

def array(list$)
	dim arr[0]
	var tmp = ""
	var i
	var c$ = ""
	for i = 0 to len(list$) - 1
		c$ = mid$(list$, i, 1)
		if c$ == " " && tmp$ != "" then
			push arr, val(tmp$)
			tmp$ = ""
		endif
		tmp$ = tmp$ + c$
	next
	if tmp$ != "" && tmp$ != " " then push arr, val(tmp$)
	return arr
end

def array$(list$)
	dim arr$[0]
	var tmp$ = ""
	var i
	var c$ = ""
	for i = 0 to len(list$) - 1
		c$ = mid$(list$, i, 1)
		if c$ == " " && tmp$ != "" then
			push arr$, tmp$
			tmp$ = ""
		else
			tmp$ = tmp$ + c$
		endif
	next
	if tmp$ != "" && tmp$ != " " then push arr$, tmp$
	return arr$
end

' 配列の内容を出力する

def arrayDump arr[]
	var i
	for i = 0 to len(arr) - 1
		? str$(arr[i]) + " ";
	next
	? ""
end

def arrayDump arr$[]
	var i
	for i = 0 to len(arr$) - 1
		? arr$[i] + " ";
	next
	? ""
end

' 定数

var UNKNOWN = 1, DIRECTION = 2, RESERVED = 3
var OPERATOR = 4, CONSTANT = 5

' 演算子

dim operators$[0]
operators$ = array$("+ - * / DIV MOD << >> NOT ( ) == != < <= > >= && || AND OR XOR !")

' 予約語

dim reservedWords$[0]
reservedWords$ = array$("IF THEN ELSE ELSEIF ENDIF GOTO GOSUB RETURN ON FOR NEXT WHILE WEND REPEAT UNTIL BREAK CONTINUE DEF END VAR DIM DATA READ RESTORE PRINT INPUT LINPUT CALL SWAP OUT COMMON USE EXEC FILES SAVE RENAME DELETE CHKFILE PRGEDIT PRGGET$ PRGSET PRGINS PRGDEL PRGSIZE PRGNAME$ XSCREEN DISPLAY VISIBLE BACKCOLOR ACLS FADE CLS COLOR LOCATE PRINT ? ATTR SCROLL FONTDEF WIDTH SPPAGE SPCLIP SPDEF SPSET SPCLR SPSHOW SPHIDE SPHOME SPOFS SPROT SPSCALE SPCOLOR SPCHR SPLINK SPUNLINK SPANIM SPSTOP SPSTART SPCHK SPVAR SPCOL SPCOLVEC SPHITINFO SPFUNC BGPAGE BGSCREEN BGCLR BGSHOW BGHIDE BGCLIP BGHOME BGOFS BGROT BGSCALE BGPUT BGFILL BGSET BGANIM BGSTOP BGSTART BGCHK BGVAR BGLOAD BGSAVE BGCOORD BGCOLOR BGFUNC GPAGE GCOLOR RGBREAD GCLIP GPRIO GCLS GPSET GLINE GCIRCLE GBOX GFILL GPAINT GCOPY GSAVE GLOAD GTRI GPUTCHR GOFS GPUTCHR16 XON XOFF BUTTON BREPEAT STICK STICKX ACCEL GYROA GYROV GYROSYNC TOUCH MICSTART MICSTOP MICDATA MICSAVE CONTROLLER VIBLATE BEEP BGMCHK BGMCLEAR BGMPLAY BGMSET BGMSETD BGMVAR BGMSTOP BGMVOL WAVSET WAVSETA EFCOFF EFCON EFCSET EFCWET TALK TALKCHK TALKSTOP BGMPAUSE BGMCONT SNDSTOP BIQUAD BQPARAM FFT IFFT FFTWFN PCMCONT PCMSTOP PCMSTREAM PCMVOL RINGCOPY ARYOP MPSTART MPSEND MPRECV MPSTAT MPNAME$ MPGET MPSET INC DEC COPY SORT RSORT PUSH UNSHIFT FILL RANDOMIZE STOP OPTION WAIT VSYNC REM KEY DTREAD TMREAD CHKLABEL CHKCALL CHKVAR DIALOG CLIPBOARD DLCOPEN")

' 組み込み定数

dim constants$[0]
constants$ = array$("ON OFF YES NO TRUE FALSE BLACK NAVY BLUE GREEN TEAL LIME AQUA CYAN MAROON PURPLE OLIVE GRAY SILVER RED FUCHSIA MAGENTA YELLOW WHITE TBLACK TMAROON TRED TGREEN TLIME TOLIVE TYELLOW TNAVY TBLUE TPURPLE TMAGENTA TTREAL TCYAN TGRAY TWHITE UP DOWN LEFT RIGHT A B X Y L R ZR ZL TROT0 TROT90 TROT180 TROT270 TREVH TREVV SPSHOW SPROT0 SPROT90 SPROT180 SPROT180 SPROT270 SPREVH SPREVV SPADD BGROT0 BGROT90 BGROT180 BGROT270 BGREVH BGREVV CHKXY CHKZ CHKUV CHKI CHKR CHKS CHKC CHKV BQAPF BQLPF BQHPF BQBPF BQBSF BQLSF BQHSF BQPEQ WFRECT WFHAMM WFHANN WFBLKM AOPADD AOPSUB AOPMUL AOPDIV AOPMAD AOPLIP AOPCLP")

' 字句解析

def lex string$, tk$[], type[]
	var record$ = ""
	dim phase[0]
	var index = 0
	var isRecorded = false
	
	while true
		var c$ = mid$(string$, index, 1)

		if c$ == "#" then
			push phase, DIRECTION
			inc index
			isRecorded = true
		elseif c$ == " " || index == len(string$) - 1 then
			if len(phase) then
				if phase[len(phase) - 1] == UNKNOWN then
					if indexOf$(reservedWords$, record$) != -1 then phase[len(phase) - 1] = RESERVED
					if indexOf$(operators$, record$) != -1 then phase[len(phase) - 1] = OPERATOR
				endif
				if phase[len(phase) - 1] == DIRECTION && indexOf$(constants$, record$) != -1 then phase[len(phase) - 1] = CONSTANT
				push type, pop(phase)
				push tk$, record$
				record$ = ""
				isRecorded = false
			endif
			inc index
		elseif c$ != " " && isRecorded == false then
			push phase, UNKNOWN
			isRecorded = true
			inc index
		else
			inc index
		endif

		if isRecorded then record$ = record$ + c$
		if index >= len(string$) then break
	wend
end

var i, n
for n = 0 to prgSize(1) - 1
	dim tk$[0]
	dim type[0]
	lex prgGet$(), tk$, type
	for i = 0 to len(tk$)
		? tk$[i] + " " + str$(type[i])
	next
next
