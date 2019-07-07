#include<stdio.h>
#define M 5
#define N 5
int main()
{
    int n;
    scanf("%d",&n);
    while(n--)
    {
        int i,sum=-100000000;
        int a[M][N];
        for( i=0;i<4;i++)
            for(int j=0;j<4;j++)
            scanf("%d",&a[i][j]);
         for(i=0;i<4;i++)
                for(int j=0;j<4;j++)
                    if(j!=i)
                for(int k=0;k<4;k++)
                if(k!=i&&k!=j)
                for(int h=0;h<4;h++)
                {
                    if(h!=j&&h!=k&&h!=i)
                    if(sum<a[0][i]+a[1][j]+a[2][k]+a[3][h])
                    sum=a[0][i]+a[1][j]+a[2][k]+a[3][h];
                }
                printf("%d\n",sum);

    }
    return 0;
}
