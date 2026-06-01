## Task 1

### 1.1

#### a

```
for i in range ( n ) :
	j = 0
	while j ∗ j < i :
		j += 1
```

$O\left(n√n\right)$

#### b

```
for i in range ( n ) :
	j = i
	while j > 0 :
		j = j // 2
```

$O\left(n{\log n}\right)$

#### c

```
def f ( n ) :
	if n == 0 :
		return 1
	else
		return 5 ∗ f ( n // 3 )
```

$O\left({\log_3 n}\right)$

#### d

```
def f ( n ) :
	if n == 0 :
		return 1
	else
		return f ( n // 3 ) + f ( n // 3 )
```

$O\left(n^{\log_3 2}\right)$

### 1.2.

Prove $T(n)=2T(n/2)+n$ implies $T(n)=\Omega(n\log n)$

$$
T(n)=\Omega(n\log n)
$$

#### Base case

For $n=1$,

$$
n\log n=1\log 1=0
$$

Assuming $T(1)\ge 0$, we have:

$$
T(1)\ge 0
$$

So the base case holds.

#### Inductive hypothesis

Assume:

$$
T(n/2)\ge \frac n2\log(n/2)
$$

#### Inductive step

Using the recurrence:

$$
T(n)=2T(n/2)+n
$$

Apply the inductive hypothesis:

$$
T(n)\ge 2\left(\frac n2\log(n/2)\right)+n
$$

$$
T(n)\ge n\log(n/2)+n
$$

Since:

$$
\log(n/2)=\log n-1
$$

we get:

$$
T(n)\ge n(\log n-1)+n
$$

$$
T(n)\ge n\log n-n+n
$$

$$
T(n)\ge n\log n
$$

Therefore:

$$
T(n)=\Omega(n\log n)
$$

### 1.3.

Prove $T(n)=2T(n/2+20)+n$ implies $T(n)=O(n\log n)$
The $+20$ makes the recurrence slightly messy, so we shift the variable.
Let:

$$
S(m)=T(m+40)
$$

Using the original recurrence with $n=m+40$:

$$
T(m+40)=2T((m+40)/2+20)+(m+40)
$$

Simplify:

$$
(m+40)/2+20=m/2+40
$$

So:

$$
S(m)=2T(m/2+40)+m+40
$$

Since:

$$
T(m/2+40)=S(m/2)
$$

we get:

$$
S(m)=2S(m/2)+m+40
$$

Now prove:

$$
S(m)=O(m\log m)
$$

We prove by induction that:

$$
S(m)\le c m\log m
$$

for sufficiently large $m$.

#### Base case

For finitely many small values of $m$, choose $c$ large enough so that:

$$
S(m)\le c m\log m
$$

#### Inductive hypothesis

Assume:

$$
S(m/2)\le c\frac m2\log(m/2)
$$

#### Inductive step

Start with:

$$
S(m)=2S(m/2)+m+40
$$

Apply the inductive hypothesis:

$$
S(m)\le 2\left(c\frac m2\log(m/2)\right)+m+40
$$

$$
S(m)\le cm\log(m/2)+m+40
$$

Since:

$$
\log(m/2)=\log m-1
$$

we get:

$$
S(m)\le cm(\log m-1)+m+40
$$

$$
S(m)\le cm\log m-cm+m+40
$$

Choose $c\ge 2$. For $m\ge 40$,

$$
m+40\le 2m\le cm
$$

So:

$$
-cm+m+40\le 0
$$

Therefore:

$$
S(m)\le cm\log m
$$

Thus:

$$
S(m)=O(m\log m)
$$

Since $S(m)=T(m+40)$, we have:

$$
T(n)=O(n\log n)
$$

### 1.4.

Prove $T(n)=\log n\cdot T(n/\log n)+n$ implies $T(n)=O(n\log n)$

We prove by strong induction that:

$$
T(n)\le cn\log n
$$

for sufficiently large $n$.

#### Base case

For finitely many small values of $n$, choose $c$ large enough so that:

$$
T(n)\le cn\log n
$$

#### Inductive hypothesis

Assume for all $k<n$:

$$
T(k)\le ck\log k
$$

The recursive input is:

$$
k=\frac n{\log n}
$$

For sufficiently large $n$,

$$
\frac n{\log n}<n
$$

so the inductive hypothesis applies:

$$
T\left(\frac n{\log n}\right)
\le
c\frac n{\log n}\log\left(\frac n{\log n}\right)
$$

#### Inductive step

Using the recurrence:

$$
T(n)=\log n\cdot T\left(\frac n{\log n}\right)+n
$$

Apply the inductive hypothesis:

$$
T(n)
\le
\log n\cdot
c\frac n{\log n}\log\left(\frac n{\log n}\right)+n
$$

Cancel $\log n$:

$$
T(n)\le cn\log\left(\frac n{\log n}\right)+n
$$

Use the log rule:

$$
\log\left(\frac n{\log n}\right)=\log n-\log\log n
$$

So:

$$
T(n)\le cn(\log n-\log\log n)+n
$$

$$
T(n)\le cn\log n-cn\log\log n+n
$$

For sufficiently large $n$, $\log\log n\ge 1$. If $c\ge 1$, then:

$$
cn\log\log n\ge n
$$

So:

$$
-cn\log\log n+n\le 0
$$

Therefore:

$$
T(n)\le cn\log n
$$

Hence:

$$
T(n)=O(n\log n)
$$

### 1.5.

Prove $T(n)=2T(\sqrt n)+1$ implies $T(n)=O(\log n)$

A direct proof of $T(n)\le c\log n$ leaves an extra $+1$, so we prove the stronger claim:

$$
T(n)\le c\log n-1
$$

This implies:

$$
T(n)=O(\log n)
$$

#### Base case

For finitely many small values of $n$, choose $c$ large enough so that:

$$
T(n)\le c\log n-1
$$

#### Inductive hypothesis

Assume:

$$
T(\sqrt n)\le c\log(\sqrt n)-1
$$

#### Inductive step

Using the recurrence:

$$
T(n)=2T(\sqrt n)+1
$$

Apply the inductive hypothesis:

$$
T(n)\le 2(c\log(\sqrt n)-1)+1
$$

$$
T(n)\le 2c\log(\sqrt n)-2+1
$$

$$
T(n)\le 2c\log(\sqrt n)-1
$$

Since:

$$
\log(\sqrt n)=\frac12\log n
$$

we get:

$$
T(n)\le 2c\left(\frac12\log n\right)-1
$$

$$
T(n)\le c\log n-1
$$

Therefore:

$$
T(n)\le c\log n
$$

Hence:

$$
T(n)=O(\log n)
$$

### 1.12

Merge Sort is stable if the merge step is implemented correctly.

```
if (left_value <= right_value)
    take from left half first;
else
    take from right half;
```

Suppose we have equal elements, but we label them by original order:

`[5a, 2, 5b, 1]`

Here 5a appeared before 5b in the original array. A stable sort must keep:

5a before 5b

Merge sort recursively splits the array:

`[5a, 2]` `[5b, 1]`

After recursively sorting both halves:

`[2, 5a]` `[1, 5b]`

Now we merge.

When comparing 5a and 5b, they are equal. The correct merge code does this:

```
if (a[i] <= a[j]) {
    tmp[k++] = a[i++];
}
```

Because `5a <= 5b`, we take 5a from the left half first.

So the result becomes:

`[1, 2, 5a, 5b]`

The original order of equal elements is preserved.
