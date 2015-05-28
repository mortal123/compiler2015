


		.data
global_buffer: .space 100
_____Temp__1: .space 4
_str_0: .asciiz "%04d"
_str_1: .asciiz "
"

		.text

main:
jal ___Main
la $t7, _____Temp__1
sw $v0, 0($t7)
li $v0, 10
syscall

___Main:
add $sp, $sp, -11408
sw $ra, 0($sp)
add $a0, $sp, 11400
sw $a0, 11404($sp)
li $a0, 10000
lw $v1, 11404($sp)
sw $a0, 0($v1)
add $a0, $sp, 11392
sw $a0, 11396($sp)
li $a0, 0
lw $v1, 11396($sp)
sw $a0, 0($v1)
add $a0, $sp, 11384
sw $a0, 11388($sp)
li $a0, 2800
lw $v1, 11388($sp)
sw $a0, 0($v1)
add $a0, $sp, 11376
sw $a0, 11380($sp)
li $a0, 0
lw $v1, 11380($sp)
sw $a0, 0($v1)
add $a0, $sp, 11368
sw $a0, 11372($sp)
li $a0, 0
lw $v1, 11372($sp)
sw $a0, 0($v1)
add $a0, $sp, 156
sw $a0, 160($sp)
li $a0, 0
lw $v1, 160($sp)
sw $a0, 0($v1)
LABEL0:
lw $a0, 11392($sp)
lw $v1, 11384($sp)
sub $a0, $a0, $v1
sw $a0, 152($sp)
lw $a0, 152($sp)
li $v1, 0
beq $a0, $v1, LABEL2
add $a0, $sp, 164
sw $a0, 148($sp)
add $a0, $sp, 11392
sw $a0, 144($sp)
lw $a0, 144($sp)
lw $a0, 0($a0)
sw $a0, 140($sp)
lw $a0, 140($sp)
addiu $a0, $a0, 1
sw $a0, 136($sp)
lw $a0, 136($sp)
lw $v1, 144($sp)
sw $a0, 0($v1)
lw $a0, 140($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 132($sp)
lw $a0, 148($sp)
lw $v1, 132($sp)
add $a0, $v1, $a0
sw $a0, 132($sp)
lw $a0, 11400($sp)
li $v1, 5
div $a0, $a0, $v1
sw $a0, 128($sp)
lw $a0, 128($sp)
lw $v1, 132($sp)
sw $a0, 0($v1)
LABEL1:
j LABEL0
LABEL2:
LABEL3:
add $a0, $sp, 11376
sw $a0, 124($sp)
li $a0, 0
lw $v1, 124($sp)
sw $a0, 0($v1)
add $a0, $sp, 156
sw $a0, 120($sp)
lw $a0, 11384($sp)
li $v1, 2
mul $a0, $a0, $v1
sw $a0, 116($sp)
lw $a0, 116($sp)
lw $v1, 120($sp)
sw $a0, 0($v1)
lw $a0, 116($sp)
li $v1, 0
beq $a0, $v1, LABEL5
add $a0, $sp, 11392
sw $a0, 112($sp)
lw $a0, 11384($sp)
lw $v1, 112($sp)
sw $a0, 0($v1)
LABEL6:
add $a0, $sp, 11376
sw $a0, 108($sp)
add $a0, $sp, 164
sw $a0, 104($sp)
lw $a0, 11392($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 100($sp)
lw $a0, 104($sp)
lw $v1, 100($sp)
add $a0, $v1, $a0
sw $a0, 100($sp)
lw $a0, 100($sp)
lw $a0, 0($a0)
sw $a0, 100($sp)
lw $a0, 100($sp)
lw $v1, 11400($sp)
mul $a0, $a0, $v1
sw $a0, 96($sp)
lw $a0, 96($sp)
sw $a0, 88($sp)
lw $a0, 108($sp)
lw $a0, 0($a0)
sw $a0, 92($sp)
lw $a0, 92($sp)
lw $v1, 88($sp)
add $a0, $v1, $a0
sw $a0, 92($sp)
lw $a0, 92($sp)
lw $v1, 108($sp)
sw $a0, 0($v1)
add $a0, $sp, 164
sw $a0, 84($sp)
lw $a0, 11392($sp)
li $v1, 4
mul $a0, $a0, $v1
sw $a0, 80($sp)
lw $a0, 84($sp)
lw $v1, 80($sp)
add $a0, $v1, $a0
sw $a0, 80($sp)
add $a0, $sp, 156
sw $a0, 76($sp)
lw $a0, 76($sp)
lw $a0, 0($a0)
sw $a0, 72($sp)
lw $a0, 72($sp)
li $v1, 1
sub $a0, $a0, $v1
sw $a0, 72($sp)
lw $a0, 72($sp)
lw $v1, 76($sp)
sw $a0, 0($v1)
lw $a0, 11376($sp)
lw $v1, 72($sp)
rem $a0, $a0, $v1
sw $a0, 68($sp)
lw $a0, 68($sp)
lw $v1, 80($sp)
sw $a0, 0($v1)
add $a0, $sp, 11376
sw $a0, 64($sp)
add $a0, $sp, 156
sw $a0, 60($sp)
lw $a0, 60($sp)
lw $a0, 0($a0)
sw $a0, 56($sp)
lw $a0, 56($sp)
li $v1, 1
sub $a0, $a0, $v1
sw $a0, 52($sp)
lw $a0, 52($sp)
lw $v1, 60($sp)
sw $a0, 0($v1)
lw $a0, 64($sp)
lw $a0, 0($a0)
sw $a0, 48($sp)
lw $a0, 48($sp)
lw $v1, 56($sp)
div $a0, $a0, $v1
sw $a0, 48($sp)
lw $a0, 48($sp)
lw $v1, 64($sp)
sw $a0, 0($v1)
add $a0, $sp, 11392
sw $a0, 44($sp)
lw $a0, 44($sp)
lw $a0, 0($a0)
sw $a0, 40($sp)
lw $a0, 40($sp)
li $v1, 1
sub $a0, $a0, $v1
sw $a0, 40($sp)
lw $a0, 40($sp)
lw $v1, 44($sp)
sw $a0, 0($v1)
lw $a0, 40($sp)
li $v1, 0
beq $a0, $v1, LABEL8
LABEL7:
add $a0, $sp, 11376
sw $a0, 36($sp)
lw $a0, 36($sp)
lw $a0, 0($a0)
sw $a0, 32($sp)
lw $a0, 32($sp)
lw $v1, 11392($sp)
mul $a0, $a0, $v1
sw $a0, 32($sp)
lw $a0, 32($sp)
lw $v1, 36($sp)
sw $a0, 0($v1)
j LABEL6
LABEL8:
LABEL4:
add $a0, $sp, 11384
sw $a0, 28($sp)
li $v1, 14
sw $v1, 20($sp)
lw $a0, 28($sp)
lw $a0, 0($a0)
sw $a0, 24($sp)
lw $a0, 24($sp)
lw $v1, 20($sp)
sub $a0, $a0, $v1
sw $a0, 24($sp)
lw $a0, 24($sp)
lw $v1, 28($sp)
sw $a0, 0($v1)
lw $a0, 11376($sp)
lw $v1, 11400($sp)
div $a0, $a0, $v1
sw $a0, 16($sp)
lw $a0, 11368($sp)
lw $v1, 16($sp)
add $a0, $v1, $a0
sw $a0, 12($sp)
la $v0, _str_0
sw $v0, -4($sp)
lw $a0, 12($sp)
sw $a0, -8($sp)
jal ___printf
add $a0, $sp, 11368
sw $a0, 8($sp)
lw $a0, 11376($sp)
lw $v1, 11400($sp)
rem $a0, $a0, $v1
sw $a0, 4($sp)
lw $a0, 4($sp)
lw $v1, 8($sp)
sw $a0, 0($v1)
j LABEL3
LABEL5:
la $v0, _str_1
sw $v0, -4($sp)
jal ___printf
li $v0, 0
lw $ra, 0($sp)
add $sp, $sp, 11408
jr $ra
lw $ra, 0($sp)
add $v0, $sp, $zero
add $sp, $sp, 11408
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
beq $t0, '0', __printf_format_fuck       # %.9d
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
