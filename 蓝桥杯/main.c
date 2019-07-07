#include<stdio.h>
int main()
{

int k,temp1=0,temp2=0,t;
    scanf("%d",&t);
    while(t--)
    {
        long int m,n,p,q;
        scanf("%lld%lld",&n,&m);
        for(p=0;p<n;p++)
            for(q=0;q<m;q++)
            {
                if(p+q==n&&2*p+4*q==m)
                { printf("%lld%lld",p,q);
                temp1=p;
                temp2=q;
                }
            }

            if(temp1+temp2!=n)
            {
                k=-1;
                printf("%d",k);
            }
                printf("\n");
    }
    return 0;

}
