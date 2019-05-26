acls

dim program[8]
program[0] = &H00
program[1] = &H61
program[2] = &H73
program[3] = &H6d
program[4] = &H01
program[5] = &H00
program[6] = &H00
program[7] = &H00

for i = 0 to len(program)-1
  ? format$("%02X", program[i]);
next

?

save "DAT:EXAMPLE", program
