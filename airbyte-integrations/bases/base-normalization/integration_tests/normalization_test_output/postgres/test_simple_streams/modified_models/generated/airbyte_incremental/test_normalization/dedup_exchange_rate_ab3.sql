{{ config(
    indexes = [{'columns':['_airbyte_emitted_at'],'type':'hash'}],
    unique_key = '_airbyte_ab_id',
    schema = "_airbyte_test_normalization",
    tags = [ "top-level-intermediate" ]
) }}
-- SQL model to build a hash column based on the values of this record
select
    {{ dbt_utils.surrogate_key([
        adapter.quote('id'),
        'currency',
        'new_column',
        adapter.quote('date'),
        'timestamp_col',
        adapter.quote('HKD@spéçiäl & characters'),
        'nzd',
        'usd',
    ]) }} as _airbyte_dedup_exchange_rate_hashid,
    tmp.*
from {{ ref('dedup_exchange_rate_ab2') }} tmp
-- dedup_exchange_rate
where 1 = 1
{{ incremental_clause('_airbyte_emitted_at') }}

