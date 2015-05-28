


		.data
global_buffer: .space 100
_____Temp__1: .space 4
___SIZE: .space 4
___a: .space 60
___b: .space 60
___c: .space 120
___L: .space 4
___i: .space 4
_____Temp__2: .space 4
_str_0: .asciiz "%d"
_str_1: .asciiz "
"
_str_2: .asciiz "%d"
_str_3: .asciiz "
"
_str_4: .asciiz "%d"
_str_5: .asciiz "
"

		.text

main:
la $a0, ___SIZE
la $t7, _____Temp__1
sw $a0, 0($t7)
li $a0, 15
la $t7, _____Temp__1
lw $v1, 0($t7)
sw $a0, 0($v1)
jal ___Main
la $t7, _____Temp__2
sw $v0, 0($t7)
li $v0, 10
syscall

___plus:
add $sp, $sp, -128
sw $ra, 0($sp)
add $a0, $sp, 120
sw $a0, 112($sp)
li $a0, 0
lw $v1, 112($sp)
sw $a0, 0($v1)
add $a0, $sp, 116
sw $a0, 108($sp)
li $a0, 0
lw $v1, 108($sp)
sw $a0, 0($v1)
LABEL1:
lw $a0, 116($sp)
lw $v1, 124($sp)
blt $a0, $v1, LABEL2
li $v1, 0
sw $v1, 104($sp)
j LABEL3
LABEL2:
li $v1, 1
sw $v1, 104($sp)
LABEL3:
lw $a0, 104($sp)
li $v1, 0
beq $a0, $v1, LABEL0
la $a0, ___c
sw $a0, 100($sp)
lw $a0, 116($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 96($sp)
lw $a0, 100($sp)
lw $v1, 96($sp)
add $a0, $v1, $a0
sw $a0, 96($sp)
la $a0, ___a
sw $a0, 92($sp)
lw $a0, 116($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 88($sp)
lw $a0, 92($sp)
lw $v1, 88($sp)
add $a0, $v1, $a0
sw $a0, 88($sp)
lw $a0, 88($sp)
lw $a0, 0($a0)
sw $a0, 88($sp)
la $a0, ___b
sw $a0, 84($sp)
lw $a0, 116($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 80($sp)
lw $a0, 84($sp)
lw $v1, 80($sp)
add $a0, $v1, $a0
sw $a0, 80($sp)
lw $a0, 80($sp)
lw $a0, 0($a0)
sw $a0, 80($sp)
lw $a0, 88($sp)
lw $v1, 80($sp)
add $a0, $v1, $a0
sw $a0, 76($sp)
lw $a0, 76($sp)
lw $v1, 120($sp)
add $a0, $v1, $a0
sw $a0, 72($sp)
lw $a0, 72($sp)
lw $v1, 96($sp)
sw $a0, 0($v1)
add $a0, $sp, 120
sw $a0, 68($sp)
li $a0, 0
lw $v1, 68($sp)
sw $a0, 0($v1)
la $a0, ___c
sw $a0, 64($sp)
lw $a0, 116($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 60($sp)
lw $a0, 64($sp)
lw $v1, 60($sp)
add $a0, $v1, $a0
sw $a0, 60($sp)
lw $a0, 60($sp)
lw $a0, 0($a0)
sw $a0, 60($sp)
lw $a0, 60($sp)
li $v1, 9
bgt $a0, $v1, LABEL4
li $v1, 0
sw $v1, 56($sp)
j LABEL5
LABEL4:
li $v1, 1
sw $v1, 56($sp)
LABEL5:
lw $a0, 56($sp)
li $v1, 0
beq $a0, $v1, LABEL6
la $a0, ___c
sw $a0, 52($sp)
lw $a0, 116($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 48($sp)
lw $a0, 52($sp)
lw $v1, 48($sp)
add $a0, $v1, $a0
sw $a0, 48($sp)
la $a0, ___c
sw $a0, 44($sp)
lw $a0, 116($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 40($sp)
lw $a0, 44($sp)
lw $v1, 40($sp)
add $a0, $v1, $a0
sw $a0, 40($sp)
lw $a0, 40($sp)
lw $a0, 0($a0)
sw $a0, 40($sp)
lw $a0, 40($sp)
li $v1, 10
sub $a0, $a0, $v1
sw $a0, 36($sp)
lw $a0, 36($sp)
lw $v1, 48($sp)
sw $a0, 0($v1)
add $a0, $sp, 120
sw $a0, 32($sp)
li $a0, 1
lw $v1, 32($sp)
sw $a0, 0($v1)
LABEL6:
add $a0, $sp, 116
sw $a0, 28($sp)
lw $a0, 28($sp)
lw $a0, 0($a0)
sw $a0, 24($sp)
lw $a0, 24($sp)
addiu $a0, $a0, 1
sw $a0, 20($sp)
lw $a0, 20($sp)
lw $v1, 28($sp)
sw $a0, 0($v1)
j LABEL1
LABEL0:
lw $a0, 120($sp)
li $v1, 0
bgt $a0, $v1, LABEL7
li $v1, 0
sw $v1, 16($sp)
j LABEL8
LABEL7:
li $v1, 1
sw $v1, 16($sp)
LABEL8:
lw $a0, 16($sp)
li $v1, 0
beq $a0, $v1, LABEL9
la $a0, ___c
sw $a0, 12($sp)
lw $a0, 116($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 8($sp)
lw $a0, 12($sp)
lw $v1, 8($sp)
add $a0, $v1, $a0
sw $a0, 8($sp)
li $a0, 1
lw $v1, 8($sp)
sw $a0, 0($v1)
lw $v0, 116($sp)
lw $ra, 0($sp)
add $sp, $sp, 128
jr $ra
j LABEL10
LABEL9:
lw $a0, 116($sp)
li $v1, 1
sub $a0, $a0, $v1
sw $a0, 4($sp)
lw $v0, 4($sp)
lw $ra, 0($sp)
add $sp, $sp, 128
jr $ra
LABEL10:
lw $ra, 0($sp)
add $v0, $sp, $zero
add $sp, $sp, 128
jr $ra

___printIntA:
add $sp, $sp, -32
sw $ra, 0($sp)
LABEL12:
lw $a0, 28($sp)
li $v1, 0
bge $a0, $v1, LABEL13
li $v1, 0
sw $v1, 24($sp)
j LABEL14
LABEL13:
li $v1, 1
sw $v1, 24($sp)
LABEL14:
lw $a0, 24($sp)
li $v1, 0
beq $a0, $v1, LABEL11
la $a0, ___a
sw $a0, 20($sp)
lw $a0, 28($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 16($sp)
lw $a0, 20($sp)
lw $v1, 16($sp)
add $a0, $v1, $a0
sw $a0, 16($sp)
lw $a0, 16($sp)
lw $a0, 0($a0)
sw $a0, 16($sp)
la $v0, _str_0
sw $v0, -4($sp)
lw $a0, 16($sp)
sw $a0, -8($sp)
jal ___printf
add $a0, $sp, 28
sw $a0, 12($sp)
lw $a0, 12($sp)
lw $a0, 0($a0)
sw $a0, 8($sp)
lw $a0, 8($sp)
li $v1, 1
sub $a0, $a0, $v1
sw $a0, 4($sp)
lw $a0, 4($sp)
lw $v1, 12($sp)
sw $a0, 0($v1)
j LABEL12
LABEL11:
la $v0, _str_1
sw $v0, -4($sp)
jal ___printf
lw $ra, 0($sp)
add $v0, $sp, $zero
add $sp, $sp, 32
jr $ra

___printIntB:
add $sp, $sp, -32
sw $ra, 0($sp)
LABEL16:
lw $a0, 28($sp)
li $v1, 0
bge $a0, $v1, LABEL17
li $v1, 0
sw $v1, 24($sp)
j LABEL18
LABEL17:
li $v1, 1
sw $v1, 24($sp)
LABEL18:
lw $a0, 24($sp)
li $v1, 0
beq $a0, $v1, LABEL15
la $a0, ___b
sw $a0, 20($sp)
lw $a0, 28($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 16($sp)
lw $a0, 20($sp)
lw $v1, 16($sp)
add $a0, $v1, $a0
sw $a0, 16($sp)
lw $a0, 16($sp)
lw $a0, 0($a0)
sw $a0, 16($sp)
la $v0, _str_2
sw $v0, -4($sp)
lw $a0, 16($sp)
sw $a0, -8($sp)
jal ___printf
add $a0, $sp, 28
sw $a0, 12($sp)
lw $a0, 12($sp)
lw $a0, 0($a0)
sw $a0, 8($sp)
lw $a0, 8($sp)
li $v1, 1
sub $a0, $a0, $v1
sw $a0, 4($sp)
lw $a0, 4($sp)
lw $v1, 12($sp)
sw $a0, 0($v1)
j LABEL16
LABEL15:
la $v0, _str_3
sw $v0, -4($sp)
jal ___printf
lw $ra, 0($sp)
add $v0, $sp, $zero
add $sp, $sp, 32
jr $ra

___printBigInt:
add $sp, $sp, -32
sw $ra, 0($sp)
LABEL20:
lw $a0, 28($sp)
li $v1, 0
bge $a0, $v1, LABEL21
li $v1, 0
sw $v1, 24($sp)
j LABEL22
LABEL21:
li $v1, 1
sw $v1, 24($sp)
LABEL22:
lw $a0, 24($sp)
li $v1, 0
beq $a0, $v1, LABEL19
la $a0, ___c
sw $a0, 20($sp)
lw $a0, 28($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 16($sp)
lw $a0, 20($sp)
lw $v1, 16($sp)
add $a0, $v1, $a0
sw $a0, 16($sp)
lw $a0, 16($sp)
lw $a0, 0($a0)
sw $a0, 16($sp)
la $v0, _str_4
sw $v0, -4($sp)
lw $a0, 16($sp)
sw $a0, -8($sp)
jal ___printf
add $a0, $sp, 28
sw $a0, 12($sp)
lw $a0, 12($sp)
lw $a0, 0($a0)
sw $a0, 8($sp)
lw $a0, 8($sp)
li $v1, 1
sub $a0, $a0, $v1
sw $a0, 4($sp)
lw $a0, 4($sp)
lw $v1, 12($sp)
sw $a0, 0($v1)
j LABEL20
LABEL19:
la $v0, _str_5
sw $v0, -4($sp)
jal ___printf
lw $ra, 0($sp)
add $v0, $sp, $zero
add $sp, $sp, 32
jr $ra

___Main:
add $sp, $sp, -124
sw $ra, 0($sp)
la $a0, ___i
sw $a0, 120($sp)
li $a0, 0
lw $v1, 120($sp)
sw $a0, 0($v1)
LABEL23:
la $t7, ___i
lw $a0, 0($t7)
la $t7, ___SIZE
lw $v1, 0($t7)
blt $a0, $v1, LABEL26
li $v1, 0
sw $v1, 116($sp)
j LABEL27
LABEL26:
li $v1, 1
sw $v1, 116($sp)
LABEL27:
lw $a0, 116($sp)
li $v1, 0
beq $a0, $v1, LABEL25
la $t7, ___i
lw $a0, 0($t7)
li $v1, 9
blt $a0, $v1, LABEL28
li $v1, 0
sw $v1, 112($sp)
j LABEL29
LABEL28:
li $v1, 1
sw $v1, 112($sp)
LABEL29:
lw $a0, 112($sp)
li $v1, 0
beq $a0, $v1, LABEL30
la $a0, ___a
sw $a0, 108($sp)
la $t7, ___i
lw $a0, 0($t7)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 104($sp)
lw $a0, 108($sp)
lw $v1, 104($sp)
add $a0, $v1, $a0
sw $a0, 104($sp)
la $t7, ___i
lw $a0, 0($t7)
addiu $a0, $a0, 1
sw $a0, 100($sp)
lw $a0, 100($sp)
lw $v1, 104($sp)
sw $a0, 0($v1)
j LABEL31
LABEL30:
la $a0, ___a
sw $a0, 96($sp)
la $t7, ___i
lw $a0, 0($t7)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 92($sp)
lw $a0, 96($sp)
lw $v1, 92($sp)
add $a0, $v1, $a0
sw $a0, 92($sp)
la $t7, ___i
lw $a0, 0($t7)
li $v1, 9
sub $a0, $a0, $v1
sw $a0, 88($sp)
lw $a0, 88($sp)
lw $v1, 92($sp)
sw $a0, 0($v1)
LABEL31:
LABEL24:
la $a0, ___i
sw $a0, 84($sp)
lw $a0, 84($sp)
lw $a0, 0($a0)
sw $a0, 80($sp)
lw $a0, 80($sp)
addiu $a0, $a0, 1
sw $a0, 76($sp)
lw $a0, 76($sp)
lw $v1, 84($sp)
sw $a0, 0($v1)
j LABEL23
LABEL25:
la $t7, ___SIZE
lw $a0, 0($t7)
li $v1, 1
sub $a0, $a0, $v1
sw $a0, 72($sp)
lw $a0, 72($sp)
sw $a0, -4($sp)
jal ___printIntA
sw $v0, 68($sp)
la $a0, ___i
sw $a0, 64($sp)
li $a0, 0
lw $v1, 64($sp)
sw $a0, 0($v1)
LABEL32:
la $t7, ___i
lw $a0, 0($t7)
la $t7, ___SIZE
lw $v1, 0($t7)
blt $a0, $v1, LABEL35
li $v1, 0
sw $v1, 60($sp)
j LABEL36
LABEL35:
li $v1, 1
sw $v1, 60($sp)
LABEL36:
lw $a0, 60($sp)
li $v1, 0
beq $a0, $v1, LABEL34
la $t7, ___SIZE
lw $a0, 0($t7)
li $v1, 2
div $a0, $a0, $v1
sw $a0, 56($sp)
la $t7, ___i
lw $a0, 0($t7)
lw $v1, 56($sp)
blt $a0, $v1, LABEL37
li $v1, 0
sw $v1, 52($sp)
j LABEL38
LABEL37:
li $v1, 1
sw $v1, 52($sp)
LABEL38:
lw $a0, 52($sp)
li $v1, 0
beq $a0, $v1, LABEL39
la $a0, ___b
sw $a0, 48($sp)
la $t7, ___i
lw $a0, 0($t7)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 44($sp)
lw $a0, 48($sp)
lw $v1, 44($sp)
add $a0, $v1, $a0
sw $a0, 44($sp)
li $a0, 7
lw $v1, 44($sp)
sw $a0, 0($v1)
j LABEL40
LABEL39:
la $a0, ___b
sw $a0, 40($sp)
la $t7, ___i
lw $a0, 0($t7)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 36($sp)
lw $a0, 40($sp)
lw $v1, 36($sp)
add $a0, $v1, $a0
sw $a0, 36($sp)
li $a0, 3
lw $v1, 36($sp)
sw $a0, 0($v1)
LABEL40:
LABEL33:
la $a0, ___i
sw $a0, 32($sp)
lw $a0, 32($sp)
lw $a0, 0($a0)
sw $a0, 28($sp)
lw $a0, 28($sp)
addiu $a0, $a0, 1
sw $a0, 24($sp)
lw $a0, 24($sp)
lw $v1, 32($sp)
sw $a0, 0($v1)
j LABEL32
LABEL34:
la $t7, ___SIZE
lw $a0, 0($t7)
li $v1, 1
sub $a0, $a0, $v1
sw $a0, 20($sp)
lw $a0, 20($sp)
sw $a0, -4($sp)
jal ___printIntB
sw $v0, 16($sp)
la $a0, ___L
sw $a0, 12($sp)
la $t7, ___SIZE
lw $a0, 0($t7)
sw $a0, -4($sp)
jal ___plus
sw $v0, 8($sp)
lw $a0, 8($sp)
lw $v1, 12($sp)
sw $a0, 0($v1)
la $t7, ___L
lw $a0, 0($t7)
sw $a0, -4($sp)
jal ___printBigInt
sw $v0, 4($sp)
li $v0, 0
lw $ra, 0($sp)
add $sp, $sp, 124
jr $ra
lw $ra, 0($sp)
add $v0, $sp, $zero
add $sp, $sp, 124
jr $ra

___getchar:
li $v0, 12
syscall
jr $ra
___printf:
la $gp, global_buffer
sw $a0, ($gp)
sw $t0, 4($gp)
sw $t1, 8($gp)
sw $t2, 12($gp)
sw $t3, 16($gp)
sw $a2, 20($gp)

__printf:
add $t2, $sp, -8
lw $t1, -4($sp)
add $t1, $t1, -1
__printf_loop:
add $t1, $t1, 1
lb $a2, ($t1)
beq $a2, 0, __printf_end
beq $a2, 37, __printf_format
beq $a2, 92, __printf_trans
__printf_normal:
li $v0, 11
lb $a0, ($t1)
syscall
j __printf_loop
__printf_format:
lb $t0, 1($t1)
beq $t0, 'd', __printf_format_d
beq $t0, 'c', __printf_format_c
beq $t0, 's', __printf_format_s
beq $t0, '.', __printf_format_fuck       # %.9d
beq $t0, 37, __printf_format_percent     # %
j __printf_normal
__printf_format_d:
li $v0, 1
lw $a0, ($t2)
syscall
j __printf_format_cont

__printf_format_c:
li $v0, 11
lw $a0, ($t2)
syscall
j __printf_format_cont
__printf_format_s:
li $v0, 4
lw $a0, ($t2)
syscall
j __printf_format_cont
__printf_format_fuck:
add $t1, $t1, 2
lw $a2, ($t2)

lb $t3, ($t1)
add $t3, -48   # $t3 .x

li $t4, 0                      # length of $a2

__calc_length:
beq $a2, 0, __printf_format_fuck_leading
add $t4, $t4, 1
div $a2, $a2, 10
j __calc_length

__printf_format_fuck_leading:
bge $t4, $t3, __printf_format_fuck_body 
li $v0, 11
li $a0, '0'
syscall
add $t3, $t3, -1
j __printf_format_fuck_leading

__printf_format_fuck_body:
li $v0, 1
lw $a0, ($t2)
syscall

__printf_format_cont:
add $t2, $t2, -4
add $t1, $t1, 1
j __printf_loop

__printf_trans:
li $v0, 11
add $t1, $t1, 1
lb $a0, ($t1)
beq $a0, 'n', __next_line
li $a0, 9                            # 	
j __ending
__next_line:
li $a0, 10							 # 

__ending:
syscall
j __printf_loop

__printf_format_percent:
li $v0, 11
add $t1, $t1, 1
li $a0, 37						     # %
syscall
j __printf_loop

__printf_end:


lw $a0, ($gp)
lw $t0, 4($gp)
lw $t1, 8($gp)
lw $t2, 12($gp)
lw $t3, 16($gp)
lw $a2, 20($gp)

jr $ra
