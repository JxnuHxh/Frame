#include <stdio.h>

int main() {
	int m,n,i,t;
	while (scanf("%d%d", &m,&n) != EOF) {
		int sum1 = 0;
		int sum2 = 0;
		if (m>n) {
			t = m;
			m = n;
			n = t;
		}
	for ( i=m;i<=n;i++){
		if(i%2){
			sum2+=i*i*i;
		}
		else{
			sum1+=i*i;
		}
    }
    printf("%d %d\n", sum1,sum2);

}
	return 0;
}
